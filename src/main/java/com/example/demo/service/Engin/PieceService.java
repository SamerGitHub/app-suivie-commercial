package com.example.demo.service.Engin;

import com.example.demo.dao.Engin.PieceRepository;
import com.example.demo.entities.Engin.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceService {
    @Autowired
    private PieceRepository pieceRepository;


    public List<Piece> getAllPiece()
    {

        return pieceRepository.findAll();

    }

    public Piece getPiece(Long id)
    {
        return pieceRepository.getPieceById(id);
    }

    public void addPiece(Piece piece) {

        pieceRepository.save(piece);

    }

    public void updatePiece(Piece piece) {

        pieceRepository.save(piece);

    }

    public void deletePiece(Long id) {
        pieceRepository.deleteById(id);

    }
}
