package com.example.bab_recipes.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CategoryService {

    private final Map<String, String> categoryToCodeMap = new HashMap<>();
    private final Map<String, String> codeToCategoryMap = new HashMap<>();

    public CategoryService() {
        categoryToCodeMap.put("한식", "kor");
        categoryToCodeMap.put("중식", "chi");
        categoryToCodeMap.put("양식", "west");
        categoryToCodeMap.put("일식", "jap");
        categoryToCodeMap.put("분식", "bun");
        categoryToCodeMap.put("밑반찬", "side");
        categoryToCodeMap.put("채식", "veg");
        categoryToCodeMap.put("야식", "night");
        categoryToCodeMap.put("베이킹", "baking");
        categoryToCodeMap.put("퓨전", "fusion");
        categoryToCodeMap.put("다이어트", "diet");

        // 역방향 매핑 생성
        for (Map.Entry<String, String> entry : categoryToCodeMap.entrySet()) {
            codeToCategoryMap.put(entry.getValue(), entry.getKey());
        }
    }

    public String getCode(String category) {
        return categoryToCodeMap.get(category);
    }

    public String getCategory(String code) {
        return codeToCategoryMap.get(code);
    }

    public Map<String, String> getCategories() {
        return categoryToCodeMap; // 카테고리 전체 반환
    }
}
