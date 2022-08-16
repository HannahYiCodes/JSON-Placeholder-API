package com.careerdevs.jsonplaceholder.models;

// NEW CONTROLLER AND MODEL FOR POSTS, TODOS, COMMENTS
public class UserModel {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private UserCompany company;
    private UserAddress address;

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

    public static class UserAddress {
        private String suite;
        private String city;
        private String zipcode;
        private AddressGeo geo;
        public static class AddressGeo {
            private String lat;
            private String lng;

            public String getLat() {
                return lat;
            }

            public String getLng() {
                return lng;
            }
        }

        public AddressGeo getGeo() {
            return geo;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }
    }

    public UserAddress getAddress() {
        return address;
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