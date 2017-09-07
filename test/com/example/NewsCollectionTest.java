package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zilles on 9/7/17.
 */
public class NewsCollectionTest {
    public static final String JSON_FOR_ARTICLE_COLLECTION = "{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"source\": \"the-washington-post\",\n" +
            "  \"sortBy\": \"top\",\n" +
            "  \"articles\": [{\n" +
            "    \"author\": \"Kelsey Snell, Kelsey Snell\",\n" +
            "    \"title\": \"Senate approves bill doubling hurricane aid package, extending federal borrowing limit\",\n" +
            "    \"description\": \"The bill heads to the House for final approval as leaders rush to approve FEMA money before emergency funds run out.\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/powerpost/mcconnell-introduces-bill-linking-hurricane-aid-package-federal-borrowing-limit/2017/09/07/2c0cf1d6-9382-11e7-8754-d478688d23b4_story.html\",\n" +
            "    \"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/09/07/National-Politics/Images/Trump_Congress_23004-f659f.jpg?t=20170517\",\n" +
            "    \"publishedAt\": \"2017-09-07T07:34:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": \"Damian Paletta, Ashley Parker, Damian Paletta, Ashley Parker\",\n" +
            "    \"title\": \"Trump, Schumer agree to pursue plan to repeal the debt ceiling\",\n" +
            "    \"description\": \"One of the people familiar described it as a “gentlemen’s agreement.”\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/news/wonk/wp/2017/09/07/trump-schumer-agree-to-pursue-plan-to-repeal-the-debt-ceiling/\",\n" +
            "    \"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/09/06/National-Politics/Images/WHTHSE2006.JPG?t=20170517\",\n" +
            "    \"publishedAt\": \"2017-09-07T17:25:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": \"Mike DeBonis, Kelsey Snell, Elise Viebeck, Mike DeBonis, Kelsey Snell, Elise Viebeck\",\n" +
            "    \"title\": \"Conservatives mount opposition to Trump’s deal with Democrats, but fail to stop it in the Senate\",\n" +
            "    \"description\": \"Leaders of the Republican Study Committee announced their opposition to the agreement, saying it “irresponsibly [ignores] the urgency of reforms.”\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/powerpost/trumps-deal-with-democrats-bewilders-his-biggest-fans--house-conservatives/2017/09/07/a651b7b6-9345-11e7-89fa-bb822a46da5b_story.html\",\n" +
            "    \"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/09/07/National-Politics/Images/06188045-3964.jpg?t=20170517\",\n" +
            "    \"publishedAt\": \"2017-09-07T07:38:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": \"Tom Hamburger, Jonathan O'Connell, Tom Hamburger, Jonathan O'Connell\",\n" +
            "    \"title\": \"Trump Jr. says nothing came of 2016 meeting with Russians\",\n" +
            "    \"description\": \"Trump tells Senate panel he consulted with a Russian lawyer because she offered information on Hillary Clinton.\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/politics/trump-jr-says-nothing-came-of-2016-meeting-with-russians/2017/09/07/43f3f2ce-93e9-11e7-89fa-bb822a46da5b_story.html\",\n" +
            "    \"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/07/31/National-Politics/Images/Botsford170111Trump10200-crop2.JPG?t=20170517\",\n" +
            "    \"publishedAt\": \"2017-09-07T06:34:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": \"Joel Achenbach, Mark Berman, Joel Achenbach, Mark Berman\",\n" +
            "    \"title\": \"Hurricane Irma ravages Caribbean islands as Florida nervously awaits historic storm’s wrath\",\n" +
            "    \"description\": \"South Florida has begun ordering evacuations along coastal regions as forecasts warned of increasing danger from Hurricane Irma.\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/news/post-nation/wp/2017/09/07/caribbean-reels-under-irmas-deadly-wrath-as-florida-nervously-tracks-monster-storm/\",\n" +
            "    \"urlToImage\": \"https://img.washingtonpost.com/pbox.php?url=http://img.washingtonpost.com/news/post-nation/wp-content/uploads/sites/23/2017/09/irma1.jpg&w=1484&op=resize&opt=1&filter=antialias&t=20170517\",\n" +
            "    \"publishedAt\": \"2017-09-07T07:55:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": \"Andrew deGrandpre, Lindsey Bever, Andrew deGrandpre, Lindsey Bever\",\n" +
            "    \"title\": \"The tiny islands ravaged by Hurricane Irma are in trouble — and begging for help\",\n" +
            "    \"description\": \"Hurricane Jose may be headed for the Caribbean islands already destroyed by Irma.\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/news/worldviews/wp/2017/09/07/the-tiny-islands-ravaged-by-hurricane-irma-are-in-trouble-and-begging-for-help/\",\n" +
            "    \"urlToImage\": \"https://img.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2017/09/07/National-Enterprise/Images/AFP_S706Q.jpg?t=20170517\",\n" +
            "    \"publishedAt\": \"2017-09-07T07:10:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": \"Jason Samenow, Brian McNoldy, Jason Samenow, Brian McNoldy\",\n" +
            "    \"title\": \"Tropical triple threat: Hurricanes Jose and Katia could join Irma striking land this weekend\",\n" +
            "    \"description\": \"Jose could hit some of the same small islands in the northern Lesser Antilles decimated by Irma.\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/news/capital-weather-gang/wp/2017/09/07/tropical-triple-threat-hurricanes-jose-and-katia-could-join-irma-in-striking-land-this-weekend/\",\n" +
            "    \"urlToImage\": \"https://img.washingtonpost.com/pbox.php?url=http://img.washingtonpost.com/blogs/capital-weather-gang/files/2017/09/Capture-3canes.png&w=1484&op=resize&opt=1&filter=antialias&t=20170517\",\n" +
            "    \"publishedAt\": \"2017-09-07T16:56:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": \"Jason Samenow, Brian McNoldy, Jason Samenow, Brian McNoldy\",\n" +
            "    \"title\": \"Category 5 Irma stays on perilous path toward Florida; hurricane watch issued\",\n" +
            "    \"description\": \"By early next week, South Carolina could well be in the storm's crosshairs.\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/news/capital-weather-gang/wp/2017/09/07/category-5-irma-stays-on-perilous-path-toward-florida-hurricane-watch-issued/\",\n" +
            "    \"urlToImage\": \"https://img.washingtonpost.com/pbox.php?url=http://img.washingtonpost.com/blogs/capital-weather-gang/files/2017/09/rbtop-animated-2.gif&w=1484&op=resize&opt=1&filter=antialias&t=20170517\",\n" +
            "    \"publishedAt\": \"2017-09-07T06:57:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": null,\n" +
            "    \"title\": \"What’s in the path of Hurricane Irma\",\n" +
            "    \"description\": \"The storm is big, fast and speeding westward toward Florida\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/graphics/2017/national/hurricane-irma/\",\n" +
            "    \"urlToImage\": \"https://www.washingtonpost.com/graphics/2017/national/hurricane-irma/img/irma-track-11am-thurs.jpg\",\n" +
            "    \"publishedAt\": \"2017-09-06T00:00:00Z\"\n" +
            "  }, {\n" +
            "    \"author\": null,\n" +
            "    \"title\": \"Everything you need to know about Hurricane Irma\",\n" +
            "    \"description\": \"Hurricane Irma is the strongest storm on record outside the Caribbean and Gulf of Mexico, and it's tracking toward the Southeast U.S.\",\n" +
            "    \"url\": \"https://www.washingtonpost.com/graphics/2017/national/hurricane-irma-updates/\",\n" +
            "    \"urlToImage\": \"https://www.washingtonpost.com/graphics/2017/national/hurricane-irma-updates/img/promo.jpg\",\n" +
            "    \"publishedAt\": \"2017-09-06T17:00:00Z\"\n" +
            "  }]\n" +
            "}";
    private NewsCollection newsCollection;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        newsCollection = gson.fromJson(JSON_FOR_ARTICLE_COLLECTION, NewsCollection.class);
    }

    @Test
    public void getStatus() throws Exception {

    }

    @Test
    public void getSource() throws Exception {

    }

    @Test
    public void getTop() throws Exception {

    }

    @Test
    public void getArticles() throws Exception {
        assertEquals("Kelsey Snell, Kelsey Snell", newsCollection.getArticles()[0].getAuthor());
    }

}