package lt.fivethreads.repositories;

import lt.fivethreads.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface RoomRepository {
    Room findById(long id);
    List<Room> getAll();
    void deleteRoom(long id);
    Room updateRoom(Room room);
    Room createRoom(Room room);
    boolean existsByNumberAndId(Long number, Long id);
    List <Room> getUnoccupiedRooms(Date startDate, Date finishDate);
    List <Room> getUnoccupiedRoomsByApartment(Date startDate, Date finishDate, Long apartmentId);
}
