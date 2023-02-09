package com.service.impl;

import com.model.Song;
import com.repository.ISongRepository;
import com.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
   private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Song song) {
        songRepository.save(song);
    }
}
