package com.example.bab_recipes.Domain;


import jakarta.persistence.*;
import jakarta.persistence.Table;


@Table(name = "Recipes")
@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @Column(nullable = false)
    private String recipeName;

    @Column(nullable = false)
    private String recipeIngredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryId")
    private Categories categories;

    @OneToOne(fetch = FetchType.LAZY) //별점때문에 1:1 설정
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ratingId")
    private Rating rating;


    public Long getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(String recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
