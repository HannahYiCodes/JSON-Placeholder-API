package com.careerdevs.jsonplaceholder.models;

public class UserModel {
//    {
//        "id": 1,
//            "name": "Leanne Graham",
//            "username": "Bret",
//            "email": "Sincere@april.biz",
//            "address": {
//        "street": "Kulas Light",
//                "suite": "Apt. 556",
//                "city": "Gwenborough",
//                "zipcode": "92998-3874",
//                "geo": {
//            "lat": "-37.3159",
//                    "lng": "81.1496"
//        }
//    },
//        "phone": "1-770-736-8031 x56442",
//            "website": "hildegard.org",
//            "company": {
//        "name": "Romaguera-Crona",
//                "catchPhrase": "Multi-layered client-server neural-net",
//                "bs": "harness real-time e-markets"
//    }

    // @JsonInclude(JsonInclude.Include.NON_NULL)
    // private String age;
    // public String getAge() {
    //      return age;
    // }
    // REMOVING THE GETTER WILL ALSO AFFECT THE FINAL OUTPUT

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private UserCompany company;

    public static class UserCompany {
        private String name;
        private String catchPhrase;
        private String bs;

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }
    }
    public UserCompany getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}
