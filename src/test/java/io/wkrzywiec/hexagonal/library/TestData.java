package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.domain.book.model.BookDetailsDTO;

import java.util.Collections;

public class TestData {

    public static BookDetailsDTO homoDeusBookDetailsDTO() {
        return BookDetailsDTO
                .builder()
                .bookExternalId("dWYyCwAAQBAJ")
                .isbn10("1473545374")
                .isbn13("9781473545373")
                .title("Homo Deus")
                .authors(Collections.singletonList("Yuval Noah Harari"))
                .publisher("Random House")
                .publishedDate("2016-09-08")
                .description("<p><b>**THE MILLION COPY BESTSELLER**</b><br> <b></b><br><b> <i>Sapiens </i>showed us where we came from. In uncertain times, <i>Homo Deus</i> shows us where we’re going.</b></p><p> Yuval Noah Harari envisions a near future in which we face a new set of challenges. <i>Homo Deus</i> explores the projects, dreams and nightmares that will shape the twenty-first century and beyond – from overcoming death to creating artificial life.</p><p> It asks the fundamental questions: how can we protect this fragile world from our own destructive power? And what does our future hold?<br> <b></b><br><b> '<i>Homo Deus</i> will shock you. It will entertain you. It will make you think in ways you had not thought before’ Daniel Kahneman, bestselling author of <i>Thinking, Fast and Slow</i></b></p>")
                .pages(528)
                .build();
    }

    public static String homoDeusGooleBooksResponse(){
        return "{\n" +
                "    \"kind\": \"books#volume\",\n" +
                "    \"id\": \"dWYyCwAAQBAJ\",\n" +
                "    \"etag\": \"wPk+fCNOrUc\",\n" +
                "    \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/dWYyCwAAQBAJ\",\n" +
                "    \"volumeInfo\": {\n" +
                "        \"title\": \"Homo Deus\",\n" +
                "        \"subtitle\": \"A Brief History of Tomorrow\",\n" +
                "        \"authors\": [\n" +
                "            \"Yuval Noah Harari\"\n" +
                "        ],\n" +
                "        \"publisher\": \"Random House\",\n" +
                "        \"publishedDate\": \"2016-09-08\",\n" +
                "        \"description\": \"<p><b>**THE MILLION COPY BESTSELLER**</b><br> <b></b><br><b> <i>Sapiens </i>showed us where we came from. In uncertain times, <i>Homo Deus</i> shows us where we’re going.</b></p><p> Yuval Noah Harari envisions a near future in which we face a new set of challenges. <i>Homo Deus</i> explores the projects, dreams and nightmares that will shape the twenty-first century and beyond – from overcoming death to creating artificial life.</p><p> It asks the fundamental questions: how can we protect this fragile world from our own destructive power? And what does our future hold?<br> <b></b><br><b> '<i>Homo Deus</i> will shock you. It will entertain you. It will make you think in ways you had not thought before’ Daniel Kahneman, bestselling author of <i>Thinking, Fast and Slow</i></b></p>\",\n" +
                "        \"industryIdentifiers\": [\n" +
                "            {\n" +
                "                \"type\": \"ISBN_10\",\n" +
                "                \"identifier\": \"1473545374\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"ISBN_13\",\n" +
                "                \"identifier\": \"9781473545373\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"readingModes\": {\n" +
                "            \"text\": true,\n" +
                "            \"image\": false\n" +
                "        },\n" +
                "        \"pageCount\": 528,\n" +
                "        \"printedPageCount\": 450,\n" +
                "        \"printType\": \"BOOK\",\n" +
                "        \"categories\": [\n" +
                "            \"Social Science / Future Studies\",\n" +
                "            \"Social Science / Anthropology / Cultural & Social\",\n" +
                "            \"Science / Biotechnology\",\n" +
                "            \"Science / Nanoscience\",\n" +
                "            \"Political Science / Public Policy / Science & Technology Policy\",\n" +
                "            \"History / Modern / 21st Century\",\n" +
                "            \"Science / General\",\n" +
                "            \"Science / Philosophy & Social Aspects\",\n" +
                "            \"History / Social History\",\n" +
                "            \"Social Science / Sociology / General\"\n" +
                "        ],\n" +
                "        \"averageRating\": 4.0,\n" +
                "        \"ratingsCount\": 21,\n" +
                "        \"maturityRating\": \"NOT_MATURE\",\n" +
                "        \"allowAnonLogging\": true,\n" +
                "        \"contentVersion\": \"1.41.33.0.preview.2\",\n" +
                "        \"panelizationSummary\": {\n" +
                "            \"containsEpubBubbles\": false,\n" +
                "            \"containsImageBubbles\": false\n" +
                "        },\n" +
                "        \"imageLinks\": {\n" +
                "            \"smallThumbnail\": \"http://books.google.com/books/content?id=dWYyCwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&imgtk=AFLRE71OlPqFEmYBczVB1QuQTgmU-vkAdiIDl6Q1djoNlXJI7xb5V06A3mHcOtkzOqXtfnlw133xD8dCeEKpDpNstSHy07WiH0Fkt8yXdW0LT8LMZ7_KCkOpgEVD9Eo4tlQ5kicNM4Hp&source=gbs_api\",\n" +
                "            \"thumbnail\": \"http://books.google.com/books/content?id=dWYyCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE73PkLs4TNB-W2uhDvXJkIB4-9G9AJ_L1iYTYLEXa3zi2kahdsN9-_0tL7WRWgujNpjMA5ZuJO7_ykFUlCWAyLzcQVcGkqUS-NOkUkEcJ_ZRrgq48URpcfBrJWQCwSWtHo5pEGkp&source=gbs_api\",\n" +
                "            \"small\": \"http://books.google.com/books/content?id=dWYyCwAAQBAJ&printsec=frontcover&img=1&zoom=2&edge=curl&imgtk=AFLRE72Hw87YN1yYrX7vZ7pIE2BFC8lRKouBK8D8tam_3h-kLqGH2DnwMotN-fVyev2VlOQ0trvVzFBja3j0FyCVkGDrp78CJPVQAETemt5dRYbW51J0Nf9KB2bcglA_PJ9et8FZ9lB7&source=gbs_api\",\n" +
                "            \"medium\": \"http://books.google.com/books/content?id=dWYyCwAAQBAJ&printsec=frontcover&img=1&zoom=3&edge=curl&imgtk=AFLRE72bKjGOHIXNZpYJV2m3UtVBm0BQfnGQDR77ngtm4dza2jUTWh3QZg2OzQB9OQMpaoi7BD_27Yvo50xXs-m0sOuIWvmQI84F5beXggyiq1PxiayP8gONj4yZYJGGrD5L2peyY-WE&source=gbs_api\"\n" +
                "        },\n" +
                "        \"language\": \"en\",\n" +
                "        \"previewLink\": \"http://books.google.pl/books?id=dWYyCwAAQBAJ&hl=&source=gbs_api\",\n" +
                "        \"infoLink\": \"https://play.google.com/store/books/details?id=dWYyCwAAQBAJ&source=gbs_api\",\n" +
                "        \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=dWYyCwAAQBAJ\"\n" +
                "    },\n" +
                "    \"layerInfo\": {\n" +
                "        \"layers\": [\n" +
                "            {\n" +
                "                \"layerId\": \"geo\",\n" +
                "                \"volumeAnnotationsVersion\": \"52\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"saleInfo\": {\n" +
                "        \"country\": \"PL\",\n" +
                "        \"saleability\": \"FOR_SALE\",\n" +
                "        \"isEbook\": true,\n" +
                "        \"listPrice\": {\n" +
                "            \"amount\": 37.99,\n" +
                "            \"currencyCode\": \"PLN\"\n" +
                "        },\n" +
                "        \"retailPrice\": {\n" +
                "            \"amount\": 37.99,\n" +
                "            \"currencyCode\": \"PLN\"\n" +
                "        },\n" +
                "        \"buyLink\": \"https://play.google.com/store/books/details?id=dWYyCwAAQBAJ&rdid=book-dWYyCwAAQBAJ&rdot=1&source=gbs_api\",\n" +
                "        \"offers\": [\n" +
                "            {\n" +
                "                \"finskyOfferType\": 1,\n" +
                "                \"listPrice\": {\n" +
                "                    \"amountInMicros\": 3.799E7,\n" +
                "                    \"currencyCode\": \"PLN\"\n" +
                "                },\n" +
                "                \"retailPrice\": {\n" +
                "                    \"amountInMicros\": 3.799E7,\n" +
                "                    \"currencyCode\": \"PLN\"\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"accessInfo\": {\n" +
                "        \"country\": \"PL\",\n" +
                "        \"viewability\": \"PARTIAL\",\n" +
                "        \"embeddable\": true,\n" +
                "        \"publicDomain\": false,\n" +
                "        \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
                "        \"epub\": {\n" +
                "            \"isAvailable\": true,\n" +
                "            \"acsTokenLink\": \"http://books.google.pl/books/download/Homo_Deus-sample-epub.acsm?id=dWYyCwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "        },\n" +
                "        \"pdf\": {\n" +
                "            \"isAvailable\": false\n" +
                "        },\n" +
                "        \"webReaderLink\": \"http://play.google.com/books/reader?id=dWYyCwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
                "        \"accessViewStatus\": \"SAMPLE\",\n" +
                "        \"quoteSharingAllowed\": false\n" +
                "    }\n" +
                "}";
    }
}
