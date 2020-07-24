package utils;

public class Payload {

    public static String getJson() {
        return  "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Appium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    public static String addBook(String isbn, String aisle, String author) {
        return "{\n" +
                "  \"name\": \"Learn Appium Automation with Java\",\n" +
                "  \"isbn\": \""+isbn+"\",\n" +
                "  \"aisle\": \""+aisle+"\",\n" +
                "  \"author\": \""+author+"\"\n" +
                "}";
    }

    public static String createJiraIssue() {
        return "{\n" +
                "  \"fields\": {\n" +
                "    \"summary\": \"Test bug 4\",\n" +
                "    \"issuetype\": {\n" +
                "      \"name\": \"Bug\"\n" +
                "    },\n" +
                "    \"project\": {\n" +
                "      \"key\": \"CLAS\"\n" +
                "    },\n" +
                "    \"description\": {\n" +
                "      \"type\": \"doc\",\n" +
                "      \"version\": 1,\n" +
                "      \"content\": [\n" +
                "        {\n" +
                "          \"type\": \"paragraph\",\n" +
                "          \"content\": [\n" +
                "            {\n" +
                "              \"text\": \"Test bug description\",\n" +
                "              \"type\": \"text\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }

    public static String getnewComment() {
        return "{\n" +
                "  \"body\": \"Adding a new comment from Rest assured\"\n" +
                "}";
    }
}
