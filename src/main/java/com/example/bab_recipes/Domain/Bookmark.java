package com.example.bab_recipes.Domain;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "Bookmark")
@Entity
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    //fetch = FetchType -> 지연로딩
    @ManyToOne(fetch = FetchType.LAZY) //Many = bookmark, one = user ->한명의 유저가 많은 북마크를 남길수 있다.
    @JoinColumn(name="userId") //foreign key(userId) reference User (UserId)
    private User user;

    @ManyToOne
    @JoinColumn(name="recipeId")
    private Recipes recipes;

    public Long getBookmarkId() {
        return bookmarkId;
    }

}
