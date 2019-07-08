package com.bethfrench.photographyportfolio.controllers;

import com.bethfrench.photographyportfolio.models.MyUserPrincipal;
import com.bethfrench.photographyportfolio.models.Photograph;
import com.bethfrench.photographyportfolio.models.dao.PhotographRepository;
import com.bethfrench.photographyportfolio.models.navbar.NavBarLink;
import com.bethfrench.photographyportfolio.storage.StorageException;
import com.bethfrench.photographyportfolio.storage.StorageFileNotFoundException;
import com.bethfrench.photographyportfolio.storage.StorageService;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.bethfrench.photographyportfolio.models.navbar.NavBarData.makeMyNavBar;


@Controller
    @RequestMapping("file")
    public class FileController {


        @Autowired
        private StorageService storageService;

        @Autowired
        private PhotographRepository photographRepository;

        public FileController() { }

        @Secured("ROLE_ADMIN")
        @GetMapping("")
        public String listUploadedFiles(Model model, HttpServletRequest request) throws IOException {

            ArrayList<NavBarLink> navBarYo = new ArrayList<>();
            makeMyNavBar(navBarYo);
            model.addAttribute("navBarYo", navBarYo);



            Iterable<Photograph> files = photographRepository.findAll();

            List<String> attrFiles = StreamSupport.stream(files.spliterator(), false)
                    .map(file -> MvcUriComponentsBuilder
                            .fromMethodName(FileController.class, "serveFile", file.path(storageService).getFileName().toString()).build().toString()
                    ).collect(Collectors.toList());

            model.addAttribute("files", attrFiles);


            return "uploadForm";
        }

        @GetMapping("{filename:.+}")
        @ResponseBody
        public ResponseEntity<Resource> serveFile(@PathVariable String filename) {




            Resource file = storageService.loadAsResource(filename);
            Tika tika = new Tika();
            String fileType;
            try {
                fileType = tika.detect(file.getFile());
            } catch (IOException e) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity
                    .ok()
                    .header("Content-Type", fileType)
                    //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
        }

        @Secured("ROLE_ADMIN")
        @PostMapping("")
        public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                       @RequestParam("color") String color,
                                       RedirectAttributes redirectAttributes, Model model) {

            ArrayList<NavBarLink> navBarYo = new ArrayList<>();
            makeMyNavBar(navBarYo);
            model.addAttribute("navBarYo", navBarYo);

            Photograph uf = new Photograph();

            uf.setColor(color);
            uf.setRating(0);

            uf.update(storageService, file);
            Tika tika = new Tika();
            String fileType;
            try {
                fileType = tika.detect(file.getBytes());
            } catch (IOException e) {
                throw new StorageException("Cannot determine file type", e);
            }

            uf.setName(file.getOriginalFilename());
            uf.setMimeType(fileType);


            photographRepository.save(uf);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");

            return "redirect:/file";
        }

        @ExceptionHandler(StorageFileNotFoundException.class)
        public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
            return ResponseEntity.notFound().build();
        }


        @ExceptionHandler(StorageException.class)
        public ResponseEntity<?> handleStorageException(StorageFileNotFoundException exc) {
            return ResponseEntity.badRequest().build();
        }

    }

