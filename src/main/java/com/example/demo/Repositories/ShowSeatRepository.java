package com.example.demo.Repositories;

import com.example.demo.modules.ShowSeats;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeats, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public List<ShowSeats> findAllByIdIn(List<Long> showSeatIds);

    public ShowSeats save(ShowSeats seat);
//    If the show seat object has id, save will update the object in db
//    Else save will insert data into DB for the first time
}
