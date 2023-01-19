package com.karabass18;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;

public class StartSet {


    @BeforeAll
    static void startSet() {
        baseURI = "https://reqres.in";
        Configuration.holdBrowserOpen = true;
    }
}
