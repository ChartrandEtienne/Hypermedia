/* CREATE DATABASE forum;
USE forum; */

delete usager;
/* delete thread; */
delete post;
delete tag;
delete tag_groupe;

drop table usager;
/* drop table thread; */
drop table post;
drop table tag;
drop table tag_groupe;

CREATE TABLE usager(
	id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY ( id ),
	nom VARCHAR(40) NOT NULL,
	password VARCHAR(40) NOT NULL
);

/****
CREATE TABLE thread (
	id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY ( id ),
	usager INT,
	FOREIGN KEY ( usager ) REFERENCES usager(id),
	titre VARCHAR(100) NOT NULL
);
*/

CREATE TABLE post (
	id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY ( id ),
	usager INT,
	FOREIGN KEY ( usager ) REFERENCES usager(id),
	url VARCHAR(300) NOT NULL,
	commentaire VARCHAR(1000) NOT NULL DEFAULT "",
	titre VARCHAR(200) NOT NULL DEFAULT "",
	datePost TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);		

CREATE TABLE tag (
	tag VARCHAR(50) NOT NULL,
	post INT NOT NULL,
	FOREIGN KEY (post) REFERENCES post(id)
);

CREATE TABLE tag_groupe (
	tag VARCHAR(50) NOT NULL,
	post INT NOT NULL,
	FOREIGN KEY (post) REFERENCES post(id)
);

INSERT INTO usager (nom, password) VALUES ("usr", "access");

INSERT INTO post (usager, url, titre) VALUES (1, "http://www.slate.com/blogs/browbeat/2013/10/24/quitting_academic_jobs_professor_zachary_ernst_and_other_leaving_tenure.html", "Qutting school");
INSERT INTO tag (tag, post) VALUES ("quitting", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("school", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("academia", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://samizdat.mines.edu/howto/HowToBeAProgrammer.html", "How to be a programmer");
INSERT INTO tag (tag, post) VALUES ("programming", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("life", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://droningearth.wordpress.com/", "Droning Earth");
INSERT INTO tag (tag, post) VALUES ("music", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("drone", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.dailygood.org/story/478/35-scientific-concepts-that-will-help-you-understand-the-world-aimee-groth/", "35 Important scientific concepts");
INSERT INTO tag (tag, post) VALUES ("science", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "https://notes.pinboard.in/u:slashnull/468a5052288a81e70fb3", "Classification");
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.raptitude.com/2010/07/your-lifestyle-has-already-been-designed/", "Designed lifestyle");
INSERT INTO tag (tag, post) VALUES ("sociology", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("bullshit", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("jobs", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.gwern.net/The Melancholy of Subculture Society", "The Melancholy of Subculture Society");
INSERT INTO tag (tag, post) VALUES ("internet", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("culture", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("sociology", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("hikkomori", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://thenewinquiry.com/essays/book-of-lamentations/", "DSM-5 as a dystopian fiction");
INSERT INTO tag (tag, post) VALUES ("dsm", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("dsm-5", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("psychology", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("sci-fi", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("dystopia", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://words.steveklabnik.com/pointers-in-rust-a-guide", "Pointers in Rust");
INSERT INTO tag (tag, post) VALUES ("pointers", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("rust", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("programming", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://allthatsevil.wordpress.com/2012/12/26/linux-domain-controller/", "Linux LDAP Domain Control");
INSERT INTO tag (tag, post) VALUES ("Linux", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("LDAP", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("Domain", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("Control", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.javaworld.com/javaworld/jw-10-2013/131015-reinventing-the-web.html?source=nww_rss", "JavaScript reinvented the web");
INSERT INTO tag (tag, post) VALUES ("javascript", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("java", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("web", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("dev", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://brandonhilkert.com/blog/3-ways-to-get-started-contributing-to-open-source/", "FOSS");
INSERT INTO tag (tag, post) VALUES ("foss", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("contribute", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.workmanlayout.com/blog/", "Workman keyboard");
INSERT INTO tag (tag, post) VALUES ("workman", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("keyboard", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("layout", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.attackmagazine.com/features/my-studio/mike-mind/", "Mike Mind Studio");
INSERT INTO tag (tag, post) VALUES ("mike", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("mind", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("studio", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.wired.com/business/2013/10/free-thinkers/", "Education Stuff");
INSERT INTO tag (tag, post) VALUES ("education", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("genius", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://akvo.org/blog/the-ball-of-mud-transition/", "Big Ball of Mud");
INSERT INTO tag (tag, post) VALUES ("software", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("design", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("ball", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("mud", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("complexity", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://pavelfatin.com/design-patterns-in-scala/", "Design Patterns in Scala");
INSERT INTO tag (tag, post) VALUES ("design", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("patterns", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("scala", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("functional", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("programming", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.alltodl.com/music/45816-yppah-discography-2006-2012-mp3.html", "Yappah");
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.wired.com/wiredscience/2013/10/topology-data-sets/", "Scientific Data Has Become So Complex, We Have to Invent New Math to Deal With It");
INSERT INTO tag (tag, post) VALUES ("big", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("data", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("analysis", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.lottieanddoof.com/2013/06/one-pan-pasta/#more-13281", "Food");
INSERT INTO tag (tag, post) VALUES ("food", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.reuters.com/article/2013/10/09/us-nobel-chemistry-idUSBRE9980AO20131009", "Nobel of Chemistry");
INSERT INTO tag (tag, post) VALUES ("chemistry", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("nobel", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cyberspace", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.flyingmachinestudios.com/programming/a-taste-of-the-lambda-calculus/", "Taste of the Lambda Calc");
INSERT INTO tag (tag, post) VALUES ("lambda", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("calculus", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://io9.com/5907235/a-math+free-guide-to-the-math-of-alice-in-wonderland", "Alice in Wonderland");
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("alice", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("wonderland", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("lewis", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("carroll", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.infoq.com/presentations/post-functional-scala-clojure-haskell", "The Expression Problem");
INSERT INTO tag (tag, post) VALUES ("functional", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("scala", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("expression", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("problem", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://worrydream.com/AlligatorEggs/", "Alligator Eggs");
INSERT INTO tag (tag, post) VALUES ("lambda", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("calculus", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("wtf", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.oftenpaper.net/sierpinski.htm", "Sierpinsky Triangle");
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("sierpinsky", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("triangle", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://plusbryan.com/my-first-5-minutes-on-a-server-or-essential-security-for-linux-servers", "Linux Safety Basics");
INSERT INTO tag (tag, post) VALUES ("linux", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("safety", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("support", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://lemire.me/blog/about-me/", "Daniel Lemire");
INSERT INTO tag (tag, post) VALUES ("montreal", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("programmer", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("blog", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://blog.fogus.me/2011/03/14/scala-fare-thee-well/", "Bunch of Scala demigods");
INSERT INTO tag (tag, post) VALUES ("scala", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.gwern.net/The%20Existential%20Risk%20of%20Mathematical%20Error", "The Existential Risk of Mathematical Error");
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("error", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("risk", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "https://kidoman.com/", "Go Faster");
INSERT INTO tag (tag, post) VALUES ("go", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("golang", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("c%252B%252B", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("ray", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("tracing", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("optimization", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://setharmstrong.com/paintings/", "Seth Armstrong");
INSERT INTO tag (tag, post) VALUES ("painting", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("art", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://grindandgore.tumblr.com/post/62988772116/iv", "Some kinda black metal");
INSERT INTO tag (tag, post) VALUES ("black", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("post", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("metal", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://stumpthegreat.tumblr.com/post/62967777255/the-fury-of-a-time-lord-valiantparadox-every", "Murray Gold");
INSERT INTO tag (tag, post) VALUES ("murray", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("gold", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("doctor", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("who", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("music", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://nick-black.com/dankwiki/index.php/Hack_on", "Nick Black Wiki");
INSERT INTO tag (tag, post) VALUES ("whoa", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.xconomy.com/national/2013/10/01/microsoft-research-memo-analysis/", "Microsoft Research");
INSERT INTO tag (tag, post) VALUES ("microsoft", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("research", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("msr", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.asymco.com/2013/10/01/competing-with-a-mac/", "BlackBerry vs Apple");
INSERT INTO tag (tag, post) VALUES ("blackberry", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("apple", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("fail", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.logicmatters.net/igt/further-notes/godel-without-tears/", "Gödel Without (Too Many) Tears");
INSERT INTO tag (tag, post) VALUES ("godel", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("incompleteness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("number", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("theory", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://blog.sqreamtech.com/2013/09/using-haskell-at-sqream-technologies/", "Using Haskell at SQream Technologies");
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("sqream", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("big", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("data", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "https://zschoche.org/debugging-in-vim/", "Debugging C/C++ in Vim");
INSERT INTO tag (tag, post) VALUES ("debugging", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("c", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("vim", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("programming", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "https://joinup.ec.europa.eu/community/osor/news/french-gendarmerie-open-source-desktop-lowers-tco-40", "French Gendarmerie: Open source desktop lowers TCO by 40%");
INSERT INTO tag (tag, post) VALUES ("linux", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("tco", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cheaper", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("windows", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("better", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("faster", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("stronger", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("harder", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.theatlantic.com/international/archive/2013/09/why-germany-s-politics-are-much-saner-cheaper-and-nicer-than-ours/280081/", "Germany politics are win");
INSERT INTO tag (tag, post) VALUES ("germany", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("politics", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("merkel", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://hackaday.com/", "Hack-a-day");
INSERT INTO tag (tag, post) VALUES ("hack", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("hardware", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "https://github.com/robrix/Postmodern-Programming/blob/master/Postmodern Programming.md", "You have to love any concept whose wikipedia page includes the heading “Subparadigms.”");
INSERT INTO tag (tag, post) VALUES ("postmodern", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("programming", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("objective-c", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.mikeash.com/pyblog/friday-qa-2013-09-27-arm64-and-you.html", "AMD64 OSX/iOS");
INSERT INTO tag (tag, post) VALUES ("amd", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("64", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cpu", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("objective-c", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.technologyreview.com/view/519581/how-google-converted-language-translation-into-a-problem-of-vector-space-mathematics/", "Google turned speech recognition into vector math");
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("wtf", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("google", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("vector", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://harishankar.org/blog/entry.php/musings-on-functional-programming-and-haskell#.UiwYyPApgAk.reddit", "Musings on fp and Haskell");
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://hackage.haskell.org/package/gloss-raster-1.8.0.1/docs/Graphics-Gloss-Raster-Array.html", "Graphics-Gloss-Raster-Array");
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("array", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("raster", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://jabsoft.io/2013/09/25/are-buffer-overflows-solved-yet-a-historical-tale/", "Are buffer overflows solved?");
INSERT INTO tag (tag, post) VALUES ("buffer", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("overflow", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("smash", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("stack", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("exploit", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("c", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://blog.plover.com/tech/prudential.html", "Shittiest project I ever worked on");
INSERT INTO tag (tag, post) VALUES ("shit", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("project", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("work", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://jliszka.github.io/2013/09/24/more-backwards-functions-unevaluating-polynomials.html", "Scala de-eval polynomials");
INSERT INTO tag (tag, post) VALUES ("scala", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("polynomial", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.grantland.com/story/_/id/9713372/looking-back-game-myst-20th-anniversary", "Myst");
INSERT INTO tag (tag, post) VALUES ("myst", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.cracked.com/article_20558_6-places-where-you-can-visit-post-apocalypse-today.html/?wa_ibsrc=fanpage", "CRACKED - apocalyptic places");
INSERT INTO tag (tag, post) VALUES ("cracked", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("apocalypse", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("industrial", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("decay", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.ycerdan.fr/linux/convertir-des-fichiers-en-utf-8-sous-linux/", "Convertir ISO/UTF");
INSERT INTO tag (tag, post) VALUES ("vim", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("iso", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("utf", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://lists.freedesktop.org/archives/nouveau/2013-September/014480.html", "Nouveau drivers spec");
INSERT INTO tag (tag, post) VALUES ("nvidia", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("nouveau", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("gpu", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("driver", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("parallel", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.washingtonpost.com/blogs/the-switch/wp/2013/09/23/this-hacker-might-seem-shady-but-throwing-him-in-jail-is-bad-for-everyone/", "Weev the scraper");
INSERT INTO tag (tag, post) VALUES ("scraping", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("hack", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("weev", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("data", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("leak", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://blog.memsql.com/oracle-announces-an-in-memory-technology-at-an-ungodly-speed-and-cost/", "Oracle 12c");
INSERT INTO tag (tag, post) VALUES ("big", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("data", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("oracle", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("database", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("columnar", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.haskell.org/haskellwiki/Numeric_Haskell:_A_Repa_Tutorial", "Repa Tutorial");
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("repa", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("devil", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("array", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("fusion", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.kernelmag.com/features/report/4716/a-russian-enigma/#", "UVB-76");
INSERT INTO tag (tag, post) VALUES ("ussr", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("weird", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("radio", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("number", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("station", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://web.mit.edu/slava/space/introduction.htm", "USSR space computers");
INSERT INTO tag (tag, post) VALUES ("USSR", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("space", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("computers", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("buran", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("vostok", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("pdp11", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.eweek.com/database/30-years-ago-the-rise-fall-and-survival-of-ashton-tates-dbase.html", "DBase");
INSERT INTO tag (tag, post) VALUES ("lame", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("old", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("database", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("dbase", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://r6.ca/blog/20110520T220201Z.html", "IO is not a Monad");
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("io", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("monad", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "https://web.math.princeton.edu/~nelson/papers/warn.pdf", "Warning Signs of a Possible Collapse of Contemporary Mathematics");
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://allthingsd.com/20110630/rim-gets-its-peanut-butter-manifesto-as-employee-rails-about-internal-woes/", "RIM jobs.");
INSERT INTO tag (tag, post) VALUES ("read", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("and", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("delete", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://anonatsudematteru.wikia.com/wiki/Ano_Natsu_De_Matteru_Wiki", "Ano Natsu De Matteru");
INSERT INTO tag (tag, post) VALUES ("anime", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cute", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "https://docs.google.com/viewer?url=http://www.cse.unsw.edu.au/~benl/papers/guiding/guiding-Haskell2012-sub.pdf", "Parallel array fusion with indexed types");
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("parallel", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("array", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("fusion", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "https://docs.google.com/viewer?url=http://research.microsoft.com/en-us/um/people/simonpj/papers/ndp/rarrays.pdf", "Regular Parallel Arrays");
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("simonpj", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("microsoft", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("pdf", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("stream", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("fusion", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("parallel", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("array", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://idontgetoutmuch.wordpress.com/", "I don't get out much");
INSERT INTO tag (tag, post) VALUES ("math", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("insane", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("cleverness", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://industrialwasteland.tumblr.com/", "Indus wasteland");
INSERT INTO tag (tag, post) VALUES ("photo", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("gif", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("industrial", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("modern", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("sci-fi", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("tumblr", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://io9.com/the-unexpected-ways-that-artificial-intelligence-might-1355337058@rtgonzalez", "Unexpected places AI will emerge");
INSERT INTO tag (tag, post) VALUES ("ai", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.andromeda.com/people/ddyer/lisp/", "Lisp machines");
INSERT INTO tag (tag, post) VALUES ("lisp", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("hardware", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://commandcenter.blogspot.de/2012/06/less-is-exponentially-more.html", "Less is exponentially more");
INSERT INTO tag (tag, post) VALUES ("C%252B%252B", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("go", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("google", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("rob", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("pike", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://feeds.feedburner.com/HighScalability?format=xml", "HighScalability");
INSERT INTO tag (tag, post) VALUES ("scale", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("web", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("big", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("data", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("database", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://bartoszmilewski.com/feed/", "C++ cafe");
INSERT INTO tag (tag, post) VALUES ("C%252B%252B", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("haskell", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO post (usager, url, titre) VALUES (1, "http://www.wired.com/wiredscience/2013/09/plutonium-238-problem/all/", "The (plutonium) Problem");
INSERT INTO tag (tag, post) VALUES ("space", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("plutonium", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("nasa", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("exploration", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
INSERT INTO tag (tag, post) VALUES ("wired", (select auto_increment from information_schema.tables where table_schema = "forum" and table_name = "post"));
*/
