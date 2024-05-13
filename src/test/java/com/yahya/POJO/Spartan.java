package com.yahya.POJO;

/**
 * Post /spartans
 *      * content type is JSON
 *      * body is
 *      * {
 *      *     "name": "API POST",
 *      *     "gender": "Male",
 *      *     "phone": 1231231234
 *      * }
 *
 *      Another common way of representing json data is using a special purpose Java Object created from a class
 *      that have fields matched to json keys
 *      and have getters and setters
 *      This type of objects sole purpose is to represent data
 *      known as POJO, plain old java object
 *      The class to create a POJO is known as POJO class
 *      It's used for creating POJO, just like you create any other object
 *
 *      for exmample: in order to represent a json data with 3 keys : name, gender, phone
 *      we can create a java class with 3 instances without additional code
 */

/**
 *               given()
 *                 .log().all()
 *                 .contentType(ContentType.JSON)
 *                 .body(bodyMap)
 *                 .when()
 *                 .post("/spartans")
 *                 .then().log().all()
 *                 .statusCode(201);
 *
 *
 */
/**
 * The only required part of POJO is
 * encapsulated fields : private instance variables public getters and setters
 * no are constructors
 */
public class Spartan {


    private String name;
    private String gender;
    private long phone;

    public Spartan(){

        // no body required
    }

    public Spartan(String name, String gender, long phone) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }
}
