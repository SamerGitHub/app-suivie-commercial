package com.example.demo.web.Engin;

import com.example.demo.entities.Engin.Piece;
import com.example.demo.service.Engin.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PieceRestController {
    @Autowired
    private PieceService pieceService;

    @GetMapping("/piece")
    public List<Piece> getAllPiece()
    {
        return pieceService.getAllPiece();

    }


    @GetMapping("/piece/{id}")
    public Piece getPiece(@PathVariable Long id)
    {

        Piece e= pieceService.getPiece(id);

        return e;
    }

    @PostMapping("/piece")
    public void addPiece(@RequestBody Piece piece)
    {
        pieceService.addPiece(piece);
    }

    @PutMapping("/piece")
    public void updatePiece(@RequestBody Piece piece)
    {
        pieceService.updatePiece(piece);
    }


    @DeleteMapping("/piece/{id}")
    public void deletePiece(@PathVariable Long id)
    {
        pieceService.deletePiece(id);
    }
}
