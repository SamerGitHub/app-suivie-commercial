package com.example.demo.dao.Engin;

import com.example.demo.entities.Engin.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends JpaRepository<Piece,Long> {

    public Piece getPieceById(Long id);

}

