package io.wkrzywiec.hexagonal.library;

import io.wkrzywiec.hexagonal.library.domain.inventory.dto.BookDetailsDTO;

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

    public static String harryPotterSearchResponse() {
        return "{\n" +
                "    \"kind\": \"books#volumes\",\n" +
                "    \"totalItems\": 614,\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"kind\": \"books#volume\",\n" +
                "            \"id\": \"DKcWE3WXoj8C\",\n" +
                "            \"etag\": \"iSwGmNbM3iE\",\n" +
                "            \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/DKcWE3WXoj8C\",\n" +
                "            \"volumeInfo\": {\n" +
                "                \"title\": \"Harry Potter and International Relations\",\n" +
                "                \"authors\": [\n" +
                "                    \"Daniel H. Nexon\",\n" +
                "                    \"Iver B. Neumann\"\n" +
                "                ],\n" +
                "                \"publisher\": \"Rowman & Littlefield\",\n" +
                "                \"publishedDate\": \"2006\",\n" +
                "                \"description\": \"Drawing on a range of historical and sociological sources, this work shows how aspects of Harry's world contain aspects of our own. It also includes chapters on the political economy of the franchise, and on the problems of studying popular culture.\",\n" +
                "                \"industryIdentifiers\": [\n" +
                "                    {\n" +
                "                        \"type\": \"ISBN_10\",\n" +
                "                        \"identifier\": \"0742539598\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"ISBN_13\",\n" +
                "                        \"identifier\": \"9780742539594\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"readingModes\": {\n" +
                "                    \"text\": false,\n" +
                "                    \"image\": true\n" +
                "                },\n" +
                "                \"pageCount\": 245,\n" +
                "                \"printType\": \"BOOK\",\n" +
                "                \"categories\": [\n" +
                "                    \"Literary Criticism\"\n" +
                "                ],\n" +
                "                \"averageRating\": 3.5,\n" +
                "                \"ratingsCount\": 7,\n" +
                "                \"maturityRating\": \"NOT_MATURE\",\n" +
                "                \"allowAnonLogging\": false,\n" +
                "                \"contentVersion\": \"preview-1.0.0\",\n" +
                "                \"panelizationSummary\": {\n" +
                "                    \"containsEpubBubbles\": false,\n" +
                "                    \"containsImageBubbles\": false\n" +
                "                },\n" +
                "                \"imageLinks\": {\n" +
                "                    \"smallThumbnail\": \"http://books.google.com/books/content?id=DKcWE3WXoj8C&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "                    \"thumbnail\": \"http://books.google.com/books/content?id=DKcWE3WXoj8C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "                },\n" +
                "                \"language\": \"en\",\n" +
                "                \"previewLink\": \"http://books.google.pl/books?id=DKcWE3WXoj8C&printsec=frontcover&dq=harry+potter&hl=&as_pt=BOOKS&cd=1&source=gbs_api\",\n" +
                "                \"infoLink\": \"http://books.google.pl/books?id=DKcWE3WXoj8C&dq=harry+potter&hl=&as_pt=BOOKS&source=gbs_api\",\n" +
                "                \"canonicalVolumeLink\": \"https://books.google.com/books/about/Harry_Potter_and_International_Relations.html?hl=&id=DKcWE3WXoj8C\"\n" +
                "            },\n" +
                "            \"saleInfo\": {\n" +
                "                \"country\": \"PL\",\n" +
                "                \"saleability\": \"NOT_FOR_SALE\",\n" +
                "                \"isEbook\": false\n" +
                "            },\n" +
                "            \"accessInfo\": {\n" +
                "                \"country\": \"PL\",\n" +
                "                \"viewability\": \"PARTIAL\",\n" +
                "                \"embeddable\": true,\n" +
                "                \"publicDomain\": false,\n" +
                "                \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "                \"epub\": {\n" +
                "                    \"isAvailable\": false\n" +
                "                },\n" +
                "                \"pdf\": {\n" +
                "                    \"isAvailable\": true,\n" +
                "                    \"acsTokenLink\": \"http://books.google.pl/books/download/Harry_Potter_and_International_Relations-sample-pdf.acsm?id=DKcWE3WXoj8C&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "                },\n" +
                "                \"webReaderLink\": \"http://play.google.com/books/reader?id=DKcWE3WXoj8C&hl=&as_pt=BOOKS&printsec=frontcover&source=gbs_api\",\n" +
                "                \"accessViewStatus\": \"SAMPLE\",\n" +
                "                \"quoteSharingAllowed\": false\n" +
                "            },\n" +
                "            \"searchInfo\": {\n" +
                "                \"textSnippet\": \"Drawing on a range of historical and sociological sources, this work shows how aspects of Harry&#39;s world contain aspects of our own.\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"kind\": \"books#volume\",\n" +
                "            \"id\": \"Aaug_RnI-xQC\",\n" +
                "            \"etag\": \"CcHxn+l25b4\",\n" +
                "            \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/Aaug_RnI-xQC\",\n" +
                "            \"volumeInfo\": {\n" +
                "                \"title\": \"The Irresistible Rise of Harry Potter\",\n" +
                "                \"authors\": [\n" +
                "                    \"Andrew Blake\"\n" +
                "                ],\n" +
                "                \"publisher\": \"Verso\",\n" +
                "                \"publishedDate\": \"2002\",\n" +
                "                \"description\": \"Blake's examination of the Potter phenomenon raises serious questions about the condition of the publishing industry, filmmaking, and the ways in which the Potter consumer campaign has changed ideas about literature and reading.\",\n" +
                "                \"industryIdentifiers\": [\n" +
                "                    {\n" +
                "                        \"type\": \"ISBN_10\",\n" +
                "                        \"identifier\": \"1859846661\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"ISBN_13\",\n" +
                "                        \"identifier\": \"9781859846667\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"readingModes\": {\n" +
                "                    \"text\": false,\n" +
                "                    \"image\": true\n" +
                "                },\n" +
                "                \"pageCount\": 118,\n" +
                "                \"printType\": \"BOOK\",\n" +
                "                \"categories\": [\n" +
                "                    \"Literary Criticism\"\n" +
                "                ],\n" +
                "                \"averageRating\": 4.5,\n" +
                "                \"ratingsCount\": 5,\n" +
                "                \"maturityRating\": \"NOT_MATURE\",\n" +
                "                \"allowAnonLogging\": false,\n" +
                "                \"contentVersion\": \"1.1.2.0.preview.1\",\n" +
                "                \"panelizationSummary\": {\n" +
                "                    \"containsEpubBubbles\": false,\n" +
                "                    \"containsImageBubbles\": false\n" +
                "                },\n" +
                "                \"imageLinks\": {\n" +
                "                    \"smallThumbnail\": \"http://books.google.com/books/content?id=Aaug_RnI-xQC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "                    \"thumbnail\": \"http://books.google.com/books/content?id=Aaug_RnI-xQC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "                },\n" +
                "                \"language\": \"en\",\n" +
                "                \"previewLink\": \"http://books.google.pl/books?id=Aaug_RnI-xQC&printsec=frontcover&dq=harry+potter&hl=&as_pt=BOOKS&cd=2&source=gbs_api\",\n" +
                "                \"infoLink\": \"http://books.google.pl/books?id=Aaug_RnI-xQC&dq=harry+potter&hl=&as_pt=BOOKS&source=gbs_api\",\n" +
                "                \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Irresistible_Rise_of_Harry_Potter.html?hl=&id=Aaug_RnI-xQC\"\n" +
                "            },\n" +
                "            \"saleInfo\": {\n" +
                "                \"country\": \"PL\",\n" +
                "                \"saleability\": \"NOT_FOR_SALE\",\n" +
                "                \"isEbook\": false\n" +
                "            },\n" +
                "            \"accessInfo\": {\n" +
                "                \"country\": \"PL\",\n" +
                "                \"viewability\": \"PARTIAL\",\n" +
                "                \"embeddable\": true,\n" +
                "                \"publicDomain\": false,\n" +
                "                \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "                \"epub\": {\n" +
                "                    \"isAvailable\": false\n" +
                "                },\n" +
                "                \"pdf\": {\n" +
                "                    \"isAvailable\": false\n" +
                "                },\n" +
                "                \"webReaderLink\": \"http://play.google.com/books/reader?id=Aaug_RnI-xQC&hl=&as_pt=BOOKS&printsec=frontcover&source=gbs_api\",\n" +
                "                \"accessViewStatus\": \"SAMPLE\",\n" +
                "                \"quoteSharingAllowed\": false\n" +
                "            },\n" +
                "            \"searchInfo\": {\n" +
                "                \"textSnippet\": \"Blake&#39;s examination of the Potter phenomenon raises serious questions about the condition of the publishing industry, filmmaking, and the ways in which the Potter consumer campaign has changed ideas about literature and reading.\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"kind\": \"books#volume\",\n" +
                "            \"id\": \"3PGBUrScs-YC\",\n" +
                "            \"etag\": \"GCMKjP2WQk4\",\n" +
                "            \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/3PGBUrScs-YC\",\n" +
                "            \"volumeInfo\": {\n" +
                "                \"title\": \"Harry Potter and the Bible\",\n" +
                "                \"subtitle\": \"The Menace Behind the Magick\",\n" +
                "                \"authors\": [\n" +
                "                    \"Richard Abanes\"\n" +
                "                ],\n" +
                "                \"publisher\": \"Wingspread Pub\",\n" +
                "                \"publishedDate\": \"2001-01-01\",\n" +
                "                \"description\": \"Is the Harry Potter phenomena harmless fantasy or dangerous fascination? This book catalogs various forms of occultism included in the first four Harry Potter books and warns against spiritual dangers.\",\n" +
                "                \"industryIdentifiers\": [\n" +
                "                    {\n" +
                "                        \"type\": \"ISBN_10\",\n" +
                "                        \"identifier\": \"0889652015\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"ISBN_13\",\n" +
                "                        \"identifier\": \"9780889652019\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"readingModes\": {\n" +
                "                    \"text\": false,\n" +
                "                    \"image\": false\n" +
                "                },\n" +
                "                \"pageCount\": 275,\n" +
                "                \"printType\": \"BOOK\",\n" +
                "                \"categories\": [\n" +
                "                    \"Religion\"\n" +
                "                ],\n" +
                "                \"averageRating\": 4.0,\n" +
                "                \"ratingsCount\": 5,\n" +
                "                \"maturityRating\": \"NOT_MATURE\",\n" +
                "                \"allowAnonLogging\": false,\n" +
                "                \"contentVersion\": \"1.0.0.0.preview.0\",\n" +
                "                \"imageLinks\": {\n" +
                "                    \"smallThumbnail\": \"http://books.google.com/books/content?id=3PGBUrScs-YC&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
                "                    \"thumbnail\": \"http://books.google.com/books/content?id=3PGBUrScs-YC&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
                "                },\n" +
                "                \"language\": \"en\",\n" +
                "                \"previewLink\": \"http://books.google.pl/books?id=3PGBUrScs-YC&q=harry+potter&dq=harry+potter&hl=&as_pt=BOOKS&cd=3&source=gbs_api\",\n" +
                "                \"infoLink\": \"http://books.google.pl/books?id=3PGBUrScs-YC&dq=harry+potter&hl=&as_pt=BOOKS&source=gbs_api\",\n" +
                "                \"canonicalVolumeLink\": \"https://books.google.com/books/about/Harry_Potter_and_the_Bible.html?hl=&id=3PGBUrScs-YC\"\n" +
                "            },\n" +
                "            \"saleInfo\": {\n" +
                "                \"country\": \"PL\",\n" +
                "                \"saleability\": \"NOT_FOR_SALE\",\n" +
                "                \"isEbook\": false\n" +
                "            },\n" +
                "            \"accessInfo\": {\n" +
                "                \"country\": \"PL\",\n" +
                "                \"viewability\": \"NO_PAGES\",\n" +
                "                \"embeddable\": false,\n" +
                "                \"publicDomain\": false,\n" +
                "                \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "                \"epub\": {\n" +
                "                    \"isAvailable\": false\n" +
                "                },\n" +
                "                \"pdf\": {\n" +
                "                    \"isAvailable\": false\n" +
                "                },\n" +
                "                \"webReaderLink\": \"http://play.google.com/books/reader?id=3PGBUrScs-YC&hl=&as_pt=BOOKS&printsec=frontcover&source=gbs_api\",\n" +
                "                \"accessViewStatus\": \"NONE\",\n" +
                "                \"quoteSharingAllowed\": false\n" +
                "            },\n" +
                "            \"searchInfo\": {\n" +
                "                \"textSnippet\": \"Examines J.K. Rowling&#39;s &quot;Harry Potter&quot; books, discussing their use of occult imagery and their potential dangers to Christians, and compares them to the &quot;safer&quot; works of C.S. Lewis and J.R.R. Tolkien.\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"kind\": \"books#volume\",\n" +
                "            \"id\": \"iO5pApw2JycC\",\n" +
                "            \"etag\": \"3V/Rwx8vImI\",\n" +
                "            \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/iO5pApw2JycC\",\n" +
                "            \"volumeInfo\": {\n" +
                "                \"title\": \"The Ivory Tower and Harry Potter\",\n" +
                "                \"subtitle\": \"Perspectives on a Literary Phenomenon\",\n" +
                "                \"authors\": [\n" +
                "                    \"Lana A. Whited\"\n" +
                "                ],\n" +
                "                \"publisher\": \"University of Missouri Press\",\n" +
                "                \"publishedDate\": \"2004\",\n" +
                "                \"description\": \"Now available in paper, The Ivory Tower and Harry Potter is the first book-length analysis of J. K. Rowling's work from a broad range of perspectives within literature, folklore, psychology, sociology, and popular culture. A significant portion of the book explores the Harry Potter series' literary ancestors, including magic and fantasy works by Ursula K. LeGuin, Monica Furlong, Jill Murphy, and others, as well as previous works about the British boarding school experience. Other chapters explore the moral and ethical dimensions of Harry's world, including objections to the series raised within some religious circles. In her new epilogue, Lana A. Whited brings this volume up to date by covering Rowling's latest book, Harry Potter and the Order of the Phoenix.\",\n" +
                "                \"industryIdentifiers\": [\n" +
                "                    {\n" +
                "                        \"type\": \"ISBN_10\",\n" +
                "                        \"identifier\": \"0826215491\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"ISBN_13\",\n" +
                "                        \"identifier\": \"9780826215499\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"readingModes\": {\n" +
                "                    \"text\": true,\n" +
                "                    \"image\": true\n" +
                "                },\n" +
                "                \"pageCount\": 418,\n" +
                "                \"printType\": \"BOOK\",\n" +
                "                \"categories\": [\n" +
                "                    \"Literary Criticism\"\n" +
                "                ],\n" +
                "                \"averageRating\": 4.5,\n" +
                "                \"ratingsCount\": 13,\n" +
                "                \"maturityRating\": \"NOT_MATURE\",\n" +
                "                \"allowAnonLogging\": false,\n" +
                "                \"contentVersion\": \"2.0.5.0.preview.3\",\n" +
                "                \"panelizationSummary\": {\n" +
                "                    \"containsEpubBubbles\": false,\n" +
                "                    \"containsImageBubbles\": false\n" +
                "                },\n" +
                "                \"imageLinks\": {\n" +
                "                    \"smallThumbnail\": \"http://books.google.com/books/content?id=iO5pApw2JycC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
                "                    \"thumbnail\": \"http://books.google.com/books/content?id=iO5pApw2JycC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
                "                },\n" +
                "                \"language\": \"en\",\n" +
                "                \"previewLink\": \"http://books.google.pl/books?id=iO5pApw2JycC&pg=PA329&dq=harry+potter&hl=&as_pt=BOOKS&cd=4&source=gbs_api\",\n" +
                "                \"infoLink\": \"http://books.google.pl/books?id=iO5pApw2JycC&dq=harry+potter&hl=&as_pt=BOOKS&source=gbs_api\",\n" +
                "                \"canonicalVolumeLink\": \"https://books.google.com/books/about/The_Ivory_Tower_and_Harry_Potter.html?hl=&id=iO5pApw2JycC\"\n" +
                "            },\n" +
                "            \"saleInfo\": {\n" +
                "                \"country\": \"PL\",\n" +
                "                \"saleability\": \"NOT_FOR_SALE\",\n" +
                "                \"isEbook\": false\n" +
                "            },\n" +
                "            \"accessInfo\": {\n" +
                "                \"country\": \"PL\",\n" +
                "                \"viewability\": \"PARTIAL\",\n" +
                "                \"embeddable\": true,\n" +
                "                \"publicDomain\": false,\n" +
                "                \"textToSpeechPermission\": \"ALLOWED\",\n" +
                "                \"epub\": {\n" +
                "                    \"isAvailable\": true,\n" +
                "                    \"acsTokenLink\": \"http://books.google.pl/books/download/The_Ivory_Tower_and_Harry_Potter-sample-epub.acsm?id=iO5pApw2JycC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
                "                },\n" +
                "                \"pdf\": {\n" +
                "                    \"isAvailable\": false\n" +
                "                },\n" +
                "                \"webReaderLink\": \"http://play.google.com/books/reader?id=iO5pApw2JycC&hl=&as_pt=BOOKS&printsec=frontcover&source=gbs_api\",\n" +
                "                \"accessViewStatus\": \"SAMPLE\",\n" +
                "                \"quoteSharingAllowed\": false\n" +
                "            },\n" +
                "            \"searchInfo\": {\n" +
                "                \"textSnippet\": \"<b>Harry</b>. <b>Potter</b>. and. the. Technology. of. Magic. Elizabeth Teare The July/August <br>\\n2001 issue of Book lists J. K. Rowling as one of the ten most influential people in <br>\\npublishing.1 She shares space on this list with John Grisham and Oprah Winfrey,<br>\\n&nbsp;...\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    public static String noBooksSearchResponse() {
        return "{\n" +
                "    \"kind\": \"books#volumes\",\n" +
                "    \"totalItems\": 0\n" +
                "}";
    }
}

