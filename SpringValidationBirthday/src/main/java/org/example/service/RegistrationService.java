package org.example.service;

import org.example.dto.FriendFormData;
import org.example.pojo.Friend;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private List<Friend> friends;

    public RegistrationService() {
        this.friends = new ArrayList<>();
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void addParticipant(Friend friend) {
        friends.add(friend);
    }

    public Optional<Friend> getFriend(LocalDate birthday){
        return friends.stream().filter(f->f.birthday().isEqual(birthday)).findFirst();
    }
}
