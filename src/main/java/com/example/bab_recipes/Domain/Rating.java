package com.example.bab_recipes.Domain;

import jakarta.persistence.*;

@Table(name = "Rating")
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId")
    private Recipes recipes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private Double rating;

    public Long getRatingId() {
        return ratingId;
    }

    public Recipes getRecipes() {
        return recipes;
    }

    public User getUser() {
        return user;
    }

    public Double getRating() {
        return rating;
    }

    public void setRecipes(Recipes recipes) {
        this.recipes = recipes;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
