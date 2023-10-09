package br.com.dcx.ufpb.eng.ApiCiclismo.enums;

public enum CyclingCategory {

    AMATEUR("amateur"),
    PROFESSIONAL("professional");
    private String category;

   CyclingCategory(String category) {
       this.category = category;
   }

   public String getCategory() {
       return category;
   }

}

