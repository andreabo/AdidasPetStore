package com.adidas.interview.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PhotoUrl {
    private static List<String> DOG = new ArrayList<>(Arrays.asList(
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/single-minded-royalty-free-image-997141470-1558379890.jpg?crop=0.671xw:1.00xh;0.0847xw,0&resize=640:*",
            "https://www.nationalgeographic.com/content/dam/animals/thumbs/rights-exempt/mammals/d/domestic-dog_thumb.jpg",
            "https://s1.eestatic.com/2019/05/17/social/La_Jungla_399220954_123067375_1024x576.jpg",
            "https://news.gsu.edu/files/2019/10/monkey-800x600.jpg",
            "https://www.petdarling.com/articulos/wp-content/uploads/2018/07/conejo-cabeza-de-le%C3%B3n-adulto.jpg"));


    public static String getRandomPhotoUrl() {
        Random random = new Random();
        int num = random.nextInt(DOG.size() - 1);
        System.out.println(num);
        //return DOG.stream().findAny().orElse("https://ichef.bbci.co.uk/news/410/cpsprodpb/10E9B/production/_109757296_gettyimages-1128004359.jpg");
        return DOG.get(num);
    }

}
