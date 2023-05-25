import ro.unibuc.info.libraries.DataBaseManager;
import ro.unibuc.info.libraries.UsersManager;
import ro.unibuc.info.model.User;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//----------------------------begin config_DB
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "";
//----------------------------end config_DB

        DataBaseManager db = new DataBaseManager(url, username, password);
        db.connect();
        db.CreateAuctionDatabase();


        // Test data
/*
        db.registerUser(new User("alex","alex@tare.com","parola"));
        db.registerUser(new User("alex","alex@alex.com","123456"));
        db.registerUser(new User("Lazaro Dalzell", "ldalzell0@hubpages.com", "68q133u"));
        db.registerUser(new User("Cariotta Klejna", "cklejna1@craigslist.org", "lrKrCuBUgGc"));
        db.registerUser(new User("Brooke Bartaletti", "bbartaletti2@nytimes.com", "q9AXWBGVVa"));
        db.registerUser(new User("Aline Fynan", "afynan3@indiegogo.com", "6STJoJM"));
        db.registerUser(new User("Shanie Porritt", "sporritt4@mayoclinic.com", "Uo17i7Pk"));
        db.registerUser(new User("Kaja Piegrome", "kpiegrome5@technorati.com", "I3A6kW5"));
        db.registerUser(new User("Pete Hayman", "phayman6@blog.com", "wvO46WPNPFrA"));
        db.registerUser(new User("Delores Graveston", "dgraveston7@vk.com", "tkBh9PSkgufz"));
        db.registerUser(new User("Fifine Dullaghan", "fdullaghan8@ovh.net", "JcwKtn"));
        db.registerUser(new User("Micheil Epsley", "mepsley9@vinaora.com", "YVkiRFvHVrUg"));
        db.registerUser(new User("Lyndsie Plowes", "lplowesa@wikia.com", "t4KX2tD"));
        db.registerUser(new User("Craggy Vahey", "cvaheyb@cam.ac.uk", "irYS8Vdt"));
        db.registerUser(new User("Harry McNeilley", "hmcneilleyc@1und1.de", "tPW27xQKenT"));
        db.registerUser(new User("Kameko Satyford", "ksatyfordd@nydailynews.com", "ybqqlmEs8i"));
        db.registerUser(new User("Kimbra Heardman", "kheardmane@cdbaby.com", "HmWIoL"));
        db.registerUser(new User("Agretha Dibbin", "adibbinf@vk.com", "yIFJ3QElBs"));
        db.registerUser(new User("Yule Farman", "yfarmang@sbwire.com", "KcDQ6c6Fml"));
        db.registerUser(new User("Danice Philcott", "dphilcotth@tumblr.com", "CfPeqcWm733"));
        db.registerUser(new User("Stella Daile", "sdailei@csmonitor.com", "p3fIJY09"));
        db.registerUser(new User("Hailey Lomasny", "hlomasnyj@webnode.com", "PM4TdNvZ"));
        db.registerUser(new User("Katee Jiroutek", "kjiroutekk@aol.com", "vGEsK2"));
        db.registerUser(new User("Jolene Jahns", "jjahnsl@nifty.com", "WJTkAf"));
        db.registerUser(new User("Pierette Fillis", "pfillism@ameblo.jp", "r488ne"));
        db.registerUser(new User("Dorian Laphorn", "dlaphornn@blog.com", "KXhPVirF"));
        db.registerUser(new User("Helenelizabeth Bussy", "hbussyo@toplist.cz", "f7ULyj"));
        db.registerUser(new User("Padgett Culpan", "pculpanp@cyberchimps.com", "JDkqJaRU"));
        db.registerUser(new User("Kevina Schindler", "kschindlerq@craigslist.org", "2rww1gbbxED"));
        db.registerUser(new User("Briano Ivachyov", "bivachyovr@cornell.edu", "ou7WOWW0fcN"));
        db.registerUser(new User("Fifi Doles", "fdoless@samsung.com", "Aeb1lxe"));
        db.registerUser(new User("Jarvis Daines", "jdainest@etsy.com", "MH9JpOjBz"));
        db.registerUser(new User("Dannel Proudlove", "dproudloveu@youku.com", "FlAPXL"));
        db.registerUser(new User("Sharon Lenney", "slenneyv@friendfeed.com", "RVPmAgwJtQ"));
        db.registerUser(new User("Augustina Mordecai", "amordecaiw@whitehouse.gov", "8uPAcv8uW"));
        db.registerUser(new User("Mady Newhouse", "mnewhousex@usda.gov", "fv74P2E3"));
        db.registerUser(new User("Emmeline Cestard", "ecestardy@miitbeian.gov.cn", "cCEKRL1Xpp"));
        db.registerUser(new User("Ignacio Staunton", "istauntonz@dailymotion.com", "hICBZzZi0g"));
        db.registerUser(new User("Caresse Johnes", "cjohnes10@discuz.net", "l1U75wa"));
        db.registerUser(new User("Dorella De Cleen", "dde11@chron.com", "ETWuKkjv"));
        db.registerUser(new User("Bengt Antonsson", "bantonsson12@angelfire.com", "aEXNdTG"));
        db.registerUser(new User("Fredericka Hannabuss", "fhannabuss13@google.fr", "Vb2hHN"));
        db.registerUser(new User("Lance Dennant", "ldennant14@ucoz.com", "GYLYiqVKApF"));
        db.registerUser(new User("Hayden Dryden", "hdryden15@timesonline.co.uk", "oLpSHpIOK"));
        db.registerUser(new User("Dee Palfery", "dpalfery16@flavors.me", "BKfdRndaE2xB"));
        db.registerUser(new User("Findlay Benjamin", "fbenjamin17@biblegateway.com", "rEtCVXuP"));
        db.registerUser(new User("Scarface Simonin", "ssimonin18@addtoany.com", "pg03GHPd"));
        db.registerUser(new User("Fallon Brandolini", "fbrandolini19@istockphoto.com", "9F0VU7"));
        db.registerUser(new User("Marya Giottoi", "mgiottoi1a@slideshare.net", "vv1YW7w"));
        db.registerUser(new User("Deedee Gould", "dgould1b@deliciousdays.com", "V5hfgQ"));
        db.registerUser(new User("Jerrome Curson", "jcurson1c@senate.gov", "2PF8HcuGG"));
        db.registerUser(new User("Heath Sexton", "hsexton1d@geocities.com", "P6xvsYcU"));
        db.registerUser(new User("Bethanne Luthwood", "bluthwood1e@cyberchimps.com", "Z43TiLPEP"));
        db.registerUser(new User("Rufe Spincke", "rspincke1f@arstechnica.com", "kRHnW1iP"));
        db.registerUser(new User("Reina Treker", "rtreker1g@jimdo.com", "B2dGOj"));
        db.registerUser(new User("Del Imort", "dimort1h@hibu.com", "DRINPdqH2R1F"));
        db.registerUser(new User("Hali Lovell", "hlovell1i@posterous.com", "VlKPi5n"));
        db.registerUser(new User("Mikey Risely", "mrisely1j@illinois.edu", "UX2E0swWo"));
        db.registerUser(new User("Daryle Fricker", "dfricker1k@chronoengine.com", "uVgS6jgwAWz"));
        db.registerUser(new User("Tobin Cleall", "tcleall1l@sogou.com", "J7paZwqtL"));
        db.registerUser(new User("Cristal Shippey", "cshippey1m@google.com", "3qfXdxt7r61C"));
        db.registerUser(new User("Beck Vahl", "bvahl1n@intel.com", "dKFLs8I"));
        db.registerUser(new User("Tobit Downe", "tdowne1o@wsj.com", "fa4E6XD5fFUO"));
        db.registerUser(new User("Karry Rumke", "krumke1p@google.com.hk", "2TtZAM"));
        db.registerUser(new User("Bevon Cressingham", "bcressingham1q@sohu.com", "T26Uac8Jbu"));
        db.registerUser(new User("Darya Knewstub", "dknewstub1r@ucoz.ru", "hoqQq71toRE"));
        db.registerUser(new User("Britni Timmons", "btimmons1s@digg.com", "TeaHwYwINR"));
        db.registerUser(new User("Pauly McKerley", "pmckerley1t@ocn.ne.jp", "hcbGDfNJZ0"));
        db.registerUser(new User("Mignon Shilstone", "mshilstone1u@fema.gov", "FQMZwqU"));
        db.registerUser(new User("Delinda Wholesworth", "dwholesworth1v@toplist.cz", "yKr1LYR8"));
        db.registerUser(new User("Murray Veare", "mveare1w@exblog.jp", "NC7dZRiD6"));
        db.registerUser(new User("Daryl MacGilfoyle", "dmacgilfoyle1x@oaic.gov.au", "Z8yGKPKZlt"));
        db.registerUser(new User("Misti Dinsey", "mdinsey1y@netlog.com", "jErjFv8Vu6L"));
        db.registerUser(new User("Parker Murfin", "pmurfin1z@yelp.com", "IqFi0k"));
        db.registerUser(new User("Gregg Sculley", "gsculley20@digg.com", "TPxXdDxFa"));
        db.registerUser(new User("Jourdan Champness", "jchampness21@utexas.edu", "wZ8cAMb"));
        db.registerUser(new User("Mitchel McIllrick", "mmcillrick22@cam.ac.uk", "ASUZohjP"));
        db.registerUser(new User("Marje Groucutt", "mgroucutt23@google.com.hk", "rCgpgwCbbl"));
        db.registerUser(new User("Adelheid Loreit", "aloreit24@smugmug.com", "4nPQyGvJi"));
        db.registerUser(new User("Krystalle Menci", "kmenci25@cbslocal.com", "PHVsE5kGC"));
        db.registerUser(new User("Carson Johantges", "cjohantges26@smugmug.com", "MQfve7"));
        db.registerUser(new User("Trueman Manshaw", "tmanshaw27@gov.uk", "YEC6B4ewDL"));
        db.registerUser(new User("Smith Audenis", "saudenis28@4shared.com", "RO0jPIKeW2c"));
        db.registerUser(new User("Stephannie Rivett", "srivett29@istockphoto.com", "rdP8Sb"));
        db.registerUser(new User("Alister Simukov", "asimukov2a@gmpg.org", "Vyo8qtCImqY"));
        db.registerUser(new User("Lyndy Martygin", "lmartygin2b@mapquest.com", "uV3DhNhXE"));
        db.registerUser(new User("Porter Wiltshear", "pwiltshear2c@nyu.edu", "kp4VR1NL"));
        db.registerUser(new User("Cash Mulder", "cmulder2d@vinaora.com", "f1KDpZ6Ip6"));
        db.registerUser(new User("Dinnie Stennet", "dstennet2e@cbsnews.com", "Tme1eCt"));
        db.registerUser(new User("Berthe Ortmann", "bortmann2f@hud.gov", "oUgiRK8z"));
        db.registerUser(new User("Worthy Brocks", "wbrocks2g@oakley.com", "rqTE3LnT"));
        db.registerUser(new User("Bobbye Birtwistle", "bbirtwistle2h@chronoengine.com", "0LYrmiw1V5ev"));
        db.registerUser(new User("Bibi Woolford", "bwoolford2i@craigslist.org", "eZAT4lTSgv"));
        db.registerUser(new User("Ulberto Heartfield", "uheartfield2j@earthlink.net", "iKJ50e"));
        db.registerUser(new User("Auria McGiffin", "amcgiffin2k@dion.ne.jp", "8HHC65A"));
        db.registerUser(new User("Brittne Attwill", "battwill2l@g.co", "6z4bdGv8go"));
        db.registerUser(new User("Torin Sybbe", "tsybbe2m@shop-pro.jp", "lShe4z"));
        db.registerUser(new User("Berny Allder", "ballder2n@reference.com", "PBfzgM9"));
        db.registerUser(new User("Sloan Linfoot", "slinfoot2o@vk.com", "JPpPSZYZ1nfw"));
        db.registerUser(new User("Felice Callery", "fcallery2p@smh.com.au", "ge1rnJu"));
        db.registerUser(new User("Fleur Dibbe", "fdibbe2q@wiley.com", "Sz4jakgAD"));
        db.registerUser(new User("Jamima Burnyate", "jburnyate2r@amazonaws.com", "r8iyAbO"));
        db.registerUser(new User("Tomasina Pavelin", "tpavelin2s@icio.us", "2e98BJ"));
        db.registerUser(new User("Nealon Calladine", "ncalladine2t@si.edu", "a5eegm6O"));
        db.registerUser(new User("Robinson Owbrick", "rowbrick2u@loc.gov", "f9ozn5OTP"));
        db.registerUser(new User("Charlena Searjeant", "csearjeant2v@java.com", "TLCyQk9l"));
        db.registerUser(new User("Kerby Rude", "krude2w@ed.gov", "VmojpRJHd93I"));
        db.registerUser(new User("Marilyn Pratchett", "mpratchett2x@imdb.com", "U38L1CWq"));
        db.registerUser(new User("Amelie Kreutzer", "akreutzer2y@cmu.edu", "rW0fmE5an"));
        db.registerUser(new User("Pren Nuemann", "pnuemann2z@stumbleupon.com", "ZaTOs68m9X"));
        db.registerUser(new User("Aggi De Filippi", "ade30@mit.edu", "N02Ev3t"));
        db.registerUser(new User("Pierce Risso", "prisso31@cnn.com", "WyuN3SKYo"));
        db.registerUser(new User("Anni Stoner", "astoner32@ucla.edu", "EmGlzt"));
        db.registerUser(new User("Kate Kirkhouse", "kkirkhouse33@google.de", "vVFmuVpQuo"));
        db.registerUser(new User("Angil Moverley", "amoverley34@marriott.com", "hj7CPakd5n"));
        db.registerUser(new User("Frasier Blakeley", "fblakeley35@artisteer.com", "oMK3lM9Edw"));
        db.registerUser(new User("Hulda Dransfield", "hdransfield36@lulu.com", "EN8tmMNL"));
        db.registerUser(new User("Heather Vinton", "hvinton37@shop-pro.jp", "n5hVOUp9o9I"));
        db.registerUser(new User("Brook Kisting", "bkisting38@telegraph.co.uk", "YES3qZdBd22"));
        db.registerUser(new User("Clemens Tidball", "ctidball39@wordpress.com", "tXKVF0f"));
        db.registerUser(new User("Abbe Stading", "astading3a@ucla.edu", "bYhivyr"));
        db.registerUser(new User("Myranda Hanselmann", "mhanselmann3b@surveymonkey.com", "T23xQUbofqId"));
        db.registerUser(new User("Fransisco Keedy", "fkeedy3c@baidu.com", "5f5GZcw"));
        db.registerUser(new User("Suzi Mussetti", "smussetti3d@slashdot.org", "bKK7Gxl"));
        db.registerUser(new User("Oliver Talkington", "otalkington3e@yandex.ru", "9HgAl318uRaD"));
        db.registerUser(new User("Zaneta Hedderly", "zhedderly3f@opera.com", "WhNLJAip"));
        db.registerUser(new User("Asher Badger", "abadger3g@zimbio.com", "ExVa5otha04"));
        db.registerUser(new User("Miguelita Kobierra", "mkobierra3h@dailymail.co.uk", "rLzmMnfkD"));
        db.registerUser(new User("Daphene Flury", "dflury3i@naver.com", "lvMZqjgfPEB"));
        db.registerUser(new User("Bailey Bussen", "bbussen3j@php.net", "7ywFupYL"));
        db.registerUser(new User("Nick McKeggie", "nmckeggie3k@123-reg.co.uk", "vrMjQZPC"));
        db.registerUser(new User("Ervin Aindriu", "eaindriu3l@virginia.edu", "r3Et0K"));
        db.registerUser(new User("Edna Mulvagh", "emulvagh3m@aboutads.info", "amaqSx7mAM"));
        db.registerUser(new User("Robyn Taffe", "rtaffe3n@apple.com", "kj73hjX"));
        db.registerUser(new User("Cynthy Matejovsky", "cmatejovsky3o@godaddy.com", "vEpQffF4Mu"));
        db.registerUser(new User("Winthrop Creese", "wcreese3p@senate.gov", "OrRGfurd"));
        db.registerUser(new User("Lelah Petegre", "lpetegre3q@altervista.org", "ePqG7h9EJaXW"));
        db.registerUser(new User("Marlo Ingleton", "mingleton3r@barnesandnoble.com", "LEsU5Am"));
        db.registerUser(new User("Jakob Georgiades", "jgeorgiades3s@google.pl", "bcyQaeubVys"));
        db.registerUser(new User("Kanya Cramp", "kcramp3t@example.com", "E6WPxCH"));
        db.registerUser(new User("Bennie Nutkin", "bnutkin3u@bing.com", "wkpcrSi"));
        db.registerUser(new User("Sondra Hitcham", "shitcham3v@artisteer.com", "PgjAWfPA"));
        db.registerUser(new User("Fancie Iacopetti", "fiacopetti3w@tripadvisor.com", "RAF7tj3"));
        db.registerUser(new User("Carce Weond", "cweond3x@upenn.edu", "5GCEj0CAICE"));
        db.registerUser(new User("Veronique Magner", "vmagner3y@mozilla.com", "lI1QJWga"));

*/
        String a = "a";
        String email;
        String userPassword;
        Scanner scanner = new Scanner(System.in);
        UsersManager u = new UsersManager(db);
        while(!a.equals("c")){
            System.out.println("\na)Create Account\nb)Log In\nc)Stop");
            a = scanner.next();

            switch (a) {
                case "a":
                    u.readUserDetails();
                    break;
                case "b":
                    email = scanner.next();
                    userPassword = scanner.next();
                    if(u.authenticate(email,userPassword)){
                        userPassword = "";
                        while(!a.equals("c")){
                            System.out.println("\na)Create Auction\nb)Show All Auctions\nc)Show All Products\nd)Register a Physical Asset\ne)Register a Digital Asset\nf)Log Out");
                            a = scanner.next();
                            switch (a){
                                case "a":
                                    u.createAuction();
                                    break;
                                case "b":
                                    u.showAuctions();
                                    break;
                                case "c":
                                    u.showDigitalAssets();
                                    u.showPhysicalAssets();
                                    break;
                                case "d":
                                    u.registerPhysicalAsset();
                                    break;
                                case "e":
                                    u.registerDigitalAsset();
                                    break;
                                case "f":
                                    u.logOut();
                                    System.out.println("You have been logged out");
                                    break;
                                default:
                                    System.out.println("Invalid input");
                            }
                        }
                        a = "";
                    }else{
                        System.out.println("Email and/or password must be wrong!");
                    }
                    break;
                case "c":
                    System.out.println("\nGood Bye!");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        scanner.close();

        db.disconnect();
    }
}