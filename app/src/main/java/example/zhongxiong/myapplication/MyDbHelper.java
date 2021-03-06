package example.zhongxiong.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by : xiaoyehai
 * Create date : 2019/9/11 20:33
 * description :数据库管理类,负责管理数据库的创建、升级工作
 */
public class MyDbHelper extends SQLiteOpenHelper {

    //数据库名字
    public static final String DB_NAME = "book.db";

    //数据库版本
    public static final int DB_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * 在数据库首次创建的时候调用，创建表以及可以进行一些表数据的初始化
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        //_id为主键并且自增长一般命名为_id
        String sql = "create table person(_id integer primary key autoincrement,name text,type integer,content text)";
        db.execSQL(sql);

        //可以给表初始化一些数据
        db.execSQL("insert into person(name,type,content) values('西游记','1','第一回\n" +
                "\n" +
                "灵根育孕源流出\n" +
                "\n" +
                "心性修持大道生\n" +
                "\n" +
                "诗曰：混沌未分天地乱，茫茫渺渺无人见。自从盘古破鸿蒙，开辟从兹清浊辨。覆载群生仰至仁，发明万物皆成善。欲知造化会元功，须看《西游释厄传》。\n" +
                "\n" +
                "盖闻天地之数，有十二万九千六百岁为一元。将一元分为十二会，乃子、丑、寅、卯、辰、巳、午、未、申、酉、戌、亥之十二支也。每会该一万八百岁。且就一日而论：子时得阳气而丑则鸡鸣，寅不通光而卯则日出，辰时食后而巳则挨排，日午天中而未则西蹉，申时晡而日落酉，戌黄昏而人定亥。譬于大数，若到戌会之终，则天地昏曚而万物否矣。再去五千四百岁，交亥会之初，则当黑暗，而两间人物俱无矣，故曰混沌。又五千四百岁，亥会将终，贞下起元，近子之会，而复逐渐开明。邵康节曰：“冬至子之半，天心无改移。一阳初动处，万物未生时。”到此天始有根。再五千四百岁，正当子会，轻清上腾，有日有月有星有辰。日月星辰，谓之四象。故曰天开于子。又经五千四百岁，子会将终，近丑之会，而逐渐坚实。《易》曰：“大哉乾元！至哉坤元！万物资生，乃顺承天。”至此，地始凝结。再五千四百岁，正当丑会，重浊下凝，有水有火有山有石有土。水火山石土，谓之五形。故曰地辟于丑。又经五千四百岁，丑会终而寅会之初，发生万物。历曰：“天气下降，地气上升；天地交合，群物皆生。”至此，天清地爽，阴阳交合。再五千四百岁，正当寅会，生人生兽生禽，正谓天地人，三才定位。故曰人生于寅。\n" +
                "\n" +
                "感盘古开辟，三皇治世，五帝定伦，世界之间，遂分为四大部洲：曰东胜神洲，曰西牛贺洲，曰南赡部洲，曰北俱芦洲。这部书单表东胜神洲。海外有一国土，名曰傲来国。国近大海，海中有一座名山，唤为花果山。此山乃十洲之祖脉，三岛之来龙，自开清浊而立，鸿蒙判后而成。真个好山！有词赋为证，赋曰：势镇汪洋，威宁瑶海。势镇汪洋，潮涌银山鱼入穴；威宁瑶海，波翻雪浪蜃离渊。水火方隅高积土，东海之处耸崇巅。丹崖怪石，削壁奇峰。丹崖上彩凤双鸣，削壁前麒麟独卧。峰头时听锦鸡鸣，石窟每观龙出入。林中有寿鹿仙狐，树上有灵禽玄鹤。瑶草奇花不谢，青松翠柏长春。仙桃常结果，修竹每留云。一条涧壑藤萝密，四面原堤草色新。正是百川会处擎天柱，万劫无移大地根。那座山正当顶上，有一块仙石。其石有三丈六尺五寸高，有二丈四尺围圆。三丈六尺五寸高，按周天三百六十五度；二丈四尺围圆，按政历二十四气，上有九窍八孔，按九宫八卦。四面更无树木遮阴，左右倒有芝兰相衬。盖自开辟以来，每受天真地秀，日精月华，感之既久，遂有灵通之意，内育仙胎。一日迸裂，产一石卵，似圆球样大，因见风，化作一个石猴，五官俱备，四肢皆全。便就学爬学走，拜了四方，目运两道金光，射冲斗府，惊动高天上圣大慈仁者玉皇大天尊玄穹高上帝，驾座金阙云宫灵霄宝殿，聚集仙卿，见有金光焰焰，即命千里眼、顺风耳开南天门观看。二将果奉旨出门外，看的真，听的明，须臾回报道：“臣奉旨观听金光之处，乃东胜神洲海东傲来小国之界，有一座花果山，山上有一仙石，石产一卵，见风化一石猴，在那里拜四方，眼运金光，射冲斗府。如今服饵水食，金光将潜息矣。”玉帝垂赐恩慈曰：“下方之物，乃天地精华所生，不足为异。”\n" +
                "\n" +
                "那猴在山中却会行走跳跃，食草木，饮涧泉，采山花，觅树果；与狼虫为伴，虎豹为群，獐鹿为友，猕猿为亲；夜宿石崖之下，朝游峰洞之中。真是“山中无甲子，寒尽不知年”。一朝天气炎热，与群猴避暑，都在松阴之下顽耍。你看他一个个：跳树攀枝，采花觅果；抛弹子，邷么儿；跑沙窝，砌宝塔；赶蜻蜓，扑蜡；参老天，拜菩萨；扯葛藤，编草帓；捉虱子，咬圪蚤；理毛衣，剔指甲；挨的挨，擦的擦；推的推，压的压；扯的扯，拉的拉。青松林下任他顽，绿水涧边随洗濯。一群猴子耍了一会，却去那山涧中洗澡，见那股涧水奔流，真个似滚瓜涌溅。古云禽有禽言，兽有兽语。众猴都道：“这股水不知是那里的水。我们今日赶闲无事，顺涧边往上溜头，寻看源流耍子去耶！”喊一声，都拖男挈女，唤弟呼兄，一齐跑来，顺涧爬山，直至源流之处，乃是一股瀑布飞泉。但见那一派白虹起，千寻雪浪飞。海风吹不断，江月照还依。冷气分青嶂，余流润翠微。潺湲名瀑布，真似挂帘帷。众猴拍手称扬道：“好水！好水！原来此处远通山脚之下，直接大海之波。”又道：“那一个有本事的，钻进去寻个源头出来不伤身体者，我等即拜他为王。”连呼了三声，忽见丛杂中跳出一个石猴，应声高叫道：“我进去！我进去！”好猴！也是他今日芳名显，时来大运通。有缘居此地，天遣入仙宫。\n')");
        db.execSQL("insert into person(name,type,content) values('仙朝','1','  一系列的议论之声此起彼伏,无论是在现场的,还是以神念跨过无数世界屏障来偷窥的,全都被眼前的场景惊呆了。qiqint.com 平板电子书\n" +
                "\n" +
                "    猴子张着嘴,睁着眼睛,以为自己是在做梦。\n" +
                "\n" +
                "    连口水流下来都不知道。\n" +
                "\n" +
                "    哪吒拿着火尖枪,脚踩着风火轮,同样目瞪口呆。\n" +
                "\n" +
                "    申公豹出来了,二十四颗定海珠在他的周身盘旋,却忘记了操纵,事实上眼前的景象告诉他,他用不用定海珠都没有任何意义了。\n" +
                "\n" +
                "    燃灯古佛也呆在那里,他是多么深沉的一个人啊,以一己之力颠覆大雪山神庙的存在,开天辟地之时便修成正果的大能,紫霄宫中听过道,当年的阐教副教主,现在的西方教副教主,什么没见过啊？但是说真的,眼前的这一幕他真的没见过。\n" +
                "\n" +
                "    镇元子不知何时出现在了万毒域中,手中执着一把拂尘,狠狠的揉着自己的额头。\n" +
                "\n" +
                "    灵山之上,如来佛祖一直在眨眼睛,仿佛眼睛出了什么毛病一般。\n" +
                "\n" +
                "    不单单是他们,玉虚宫中,元始天尊失手打碎了手中的玉如意;碧游宫中,通天教主将出鞘一半的诛仙四剑插了回去,哈哈的狂笑起来;兜率宫中,老君仿佛想到了什么,无奈的一叹,对着坐在自己对面的玄都**师苦笑着摇了摇头……\n" +
                "\n" +
                "    准提与接引面面相觑,一副不知所措的模样。\n" +
                "\n" +
                "    紫霄宫中,一位老者似乎在思索着什么,一只手在云**上写写画画,过了好一会儿,方才抬起头。\n" +
                "\n" +
                "    此时,万毒域中的战斗还在继续着。\n" +
                "\n" +
                "    二师兄正在和毒祖战斗,确切的说,是在和毒祖的神念在战斗\n" +
                "\n" +
                "    不仅仅是在战斗,而且还是压着毒祖打。\n')");
        db.execSQL("insert into person(name,type,content) values('修仙有劫','1','八零电子书免费为书友提供陈抖抖创作的修仙有劫txt全集下载;如果你觉得本站提供的txt电子书免费下载不错,请把修仙有劫txt全集下载分享推荐给你的朋友！\n" +
                "我命由我，不由天；我命由我，不由仙；我命由我，不由人！&nb......sp;少年莫名其妙的变成了一个婴儿，来到一个仙魔汇聚的世界......这里有能够上天入地的仙魔鬼怪，有着一位位追求长生的修仙者......少年在这个世界诞生三年，父母遭仇家追杀失去踪迹，为寻父母，少年决定要修')");
        db.execSQL("insert into person(name,type,content) values('安徒生童话','2','看罢多时，跳过桥中间，左右观看，只见正当中有一石碣。碣上有一行楷书大字，镌着“花果山福地，水帘洞洞天”。石猿喜不自胜，急抽身往外便走，复瞑目蹲身，跳出水外，打了两个呵呵道：“大造化！大造化！”众猴把他围住问道：“里面怎么样？水有多深？”石猴道：“没水！没水！原来是一座铁板桥。桥那边是一座天造地设的家当。”众猴道：“怎见得是个家当？”石猴笑道：“这股水乃是桥下冲贯石窍，倒挂下来遮闭门户的。桥边有花有树，乃是一座石房。房内有石锅石灶、石碗石盆、石床石凳，中间一块石碣上，镌着‘花果山福地，水帘洞洞天’。真个是我们安身之处。里面且是宽阔，容得千百口老小。我们都进去住，也省得受老天之气。这里边刮风有处躲，下雨好存身。霜雪全无惧，雷声永不闻。烟霞常照耀，祥瑞每蒸熏。松竹年年秀，奇花日日新。”\n" +
                "\n" +
                "众猴听得，个个欢喜，都道：“你还先走，带我们进去进去！”石猴却又瞑目蹲身，往里一跳，叫道：“都随我进来！进来！”那些猴有胆大的，都跳进去了；胆小的，一个个伸头缩颈，抓耳挠腮，大声叫喊，缠一会，也都进去了。跳过桥头，一个个抢盆夺碗，占灶争床，搬过来，移过去，正是猴性顽劣，再无一个宁时，只搬得力倦神疲方止。石猿端坐上面道：“列位呵，人而无信，不知其可。你们才说有本事进得来、出得去不伤身体者，就拜他为王。我如今进来又出去，出去又进来，寻了这一个洞天与列位安眠稳睡，各享成家之福，何不拜我为王？”众猴听说，即拱伏无违，一个个序齿排班，朝上礼拜，都称“千岁大王”。自此，石猿高登王位，将石字儿隐了，遂称美猴王。有诗为证，诗曰：三阳交泰产群生，仙石胞含日月精。借卵化猴完大道，假他名姓配丹成。内观不识因无相，外合明知作有形。历代人人皆属此，称王称圣任纵横。美猴王领一群猿猴、猕猴、马猴等，分派了君臣佐使，朝游花果山，暮宿水帘洞，合契同情，不入飞鸟之丛，不从走兽之类，独自为王，不胜欢乐。是以春采百花为饮食，夏寻诸果作生涯。秋收芋栗延时节，冬觅黄精度岁华。\n" +
                "\n" +
                "美猴王享乐天真，何期有三五百载。一日，与群猴喜宴之间，忽然忧恼，堕下泪来，众猴慌忙罗拜道：“大王何为烦恼？”猴王道：“我虽在欢喜之时，却有一点儿远虑，故此烦恼。”众猴又笑道：“大王好不知足！我等日日欢会，在仙山福地，古洞神洲，不伏麒麟辖，不伏凤凰管，又不伏人王拘束，自由自在，乃无量之福，为何远虑而忧也？”猴王道：“今日虽不归人王法律，不惧禽兽威服，将来年老血衰，暗中有阎王老子管着，一旦身亡，可不枉生世界之中，不得久注天人之内？”众猴闻此言，一个个掩面悲啼，俱以无常为虑。只见那班部中，忽跳出一个通背猿猴，厉声高叫道：“大王若是这般远虑，真所谓道心开发也！如今五虫之内，惟有三等名色，不伏阎王老子所管。”猴王道：“你知那三等人？”猿猴道：“乃是佛与仙与神圣三者，躲过轮回，不生不灭，与天地山川齐寿。”猴王道：“此三者居于何所？”猿猴道：“他只在阎浮世界之中，古洞仙山之内。”猴王闻之，满心欢喜道：“我明日就辞汝等下山，云游海角，远涉天涯，务必访此三者，学一个不老长生，常躲过阎君之难。”噫！这句话，顿教跳出轮回网，致使齐天大圣成。众猴鼓掌称扬，都道：“善哉！善哉！我等明日越岭登山，广寻些果品，大设筵宴送大王也。”\n" +
                "\n" +
                "次日，众猴果去采仙桃，摘异果，刨山药，黄精，芝兰香蕙，瑶草奇花，般般件件，整整齐齐，摆开石凳石桌，排列仙酒仙肴。但见那：金丸珠弹，红绽黄肥。金丸珠弹腊樱桃，色真甘美；红绽黄肥熟梅子，味果香酸。鲜龙眼，肉甜皮薄；火荔枝，核小瓤红。林檎碧实连枝献，枇杷缃苞带叶擎。兔头梨子鸡心枣，消渴除烦更解酲。香桃烂杏，美甘甘似玉液琼浆；脆李杨梅，酸荫荫如脂酥膏酪。红瓤黑子熟西瓜，四瓣黄皮大柿子。石榴裂破，丹砂粒现火晶珠；芋栗剖开，坚硬肉团金玛瑙。胡桃银杏可传茶，椰子葡萄能做酒。榛松榧柰满盘盛，橘蔗柑橙盈案摆。熟煨山药，烂煮黄精。捣碎茯苓并薏苡，石锅微火漫炊羹。人间纵有珍羞味，怎比山猴乐更宁？群猴尊美猴王上坐，各依齿肩排于下边，一个个轮流上前奉酒奉花奉果，痛饮了一日。次日，美猴王早起，教：“小的们，替我折些枯松，编作筏子，取个竹竿作篙，收拾些果品之类，我将去也。”果独自登筏，尽力撑开，飘飘荡荡，径向大海波中，趁天风来渡南赡部洲地界。这一去，正是那：天产仙猴道行隆，离山驾筏趁天风。飘洋过海寻仙道，立志潜心建大功。有分有缘休俗愿，无忧无虑会元龙。料应必遇知音者，说破源流万法通。也是他运至时来，自登木筏之后，连日东南风紧，将他送到西北岸前，乃是南赡部洲地界。持篙试水，偶得浅水，弃了筏子，跳上岸来，只见海边有人捕鱼打雁，挖蛤淘盐。他走近前，弄个把戏，妆个虎，吓得那些人丢筐弃网，四散奔跑，将那跑不动的拿住一个，剥了他的衣裳，也学人穿在身上，摇摇摆摆，穿州过府，在市廛中学人礼学人话，朝餐夜宿，一心里访问佛仙神圣之道，觅个长生不老之方。见世人都是为名为利之徒，更无一个为身命者，正是那：争名夺利几时休？早起迟眠不自由！骑着驴骡思骏马，官居宰相望王侯。只愁衣食耽劳碌，何怕阎君就取勾？继子荫孙图富贵，更无一个肯回头！\n" +
                "\n" +
                "猴王参访仙道，无缘得遇，在于南赡部洲，串长城，游小县，不觉八九年余。忽行至西洋大海，他想着海外必有神仙，独自个依前作筏，又飘过西海，直至西牛贺洲地界。登岸遍访多时，忽见一座高山秀丽，林麓幽深。他也不怕狼虫，不惧虎豹，登山顶上观看。果是好山：千峰排戟，万仞开屏。日映岚光轻锁翠，雨收黛色冷含青。枯藤缠老树，古渡界幽程。奇花瑞草，修竹乔松。修竹乔松，万载常青欺福地；奇花瑞草，四时不谢赛蓬瀛。幽鸟啼声近，源泉响溜清。重重谷壑芝兰绕，处处巉崖苔藓生。起伏峦头龙脉好，必有高人隐姓名。')");
        db.execSQL("insert into person(name,type,content) values('格林童话','2','少顷间，只听得呀的一声，洞门开处，里面走出一个仙童，真个丰姿英伟，像貌清奇，比寻常俗子不同，但见他：髽髻双丝绾，宽袍两袖风。貌和身自别，心与相俱空。物外长年客，山中永寿童。一尘全不染，甲子任翻腾。那童子出得门来，高叫道：“甚么人在此搔扰？”猴王扑的跳下树来，上前躬身道：“仙童，我是个访道学仙之弟子，更不敢在此搔扰。”仙童笑道：“你是个访道的么？”猴王道：“是。”童子道：“我家师父正才下榻登坛讲道，还未说出原由，就教我出来开门，说：‘外面有个修行的来了，可去接待接待。’想必就是你了？”猴王笑道：“是我是我。”童子道：“你跟我进来。”\n" +
                "\n" +
                "这猴王整衣端肃，随童子径入洞天深处观看：一层层深阁琼楼，一进进珠宫贝阙，说不尽那静室幽居，直至瑶台之下。见那菩提祖师端坐在台上，两边有三十个小仙侍立台下，果然是：大觉金仙没垢姿，西方妙相祖菩提。不生不灭三三行，全气全神万万慈。空寂自然随变化，真如本性任为之。与天同寿庄严体，历劫明心大法师。美猴王一见，倒身下拜，磕头不计其数，口中只道：“师父！师父！我弟子志心朝礼！志心朝礼！”祖师道：“你是那方人氏？且说个乡贯姓名明白再拜。”猴王道：“弟子乃东胜神洲傲来国花果山水帘洞人氏。”祖师喝令：“赶出去！他本是个撒诈捣虚之徒，那里修甚么道果！”猴王慌忙磕头不住道：“弟子是老实之言，决无虚诈。”祖师道：“你既老实，怎么说东胜神洲？那去处到我这里，隔两重大海，一座南赡部洲，如何就得到此？”猴王叩头道：“弟子飘洋过海，登界游方，有十数个年头，方才访到此处。”祖师道：“既是逐渐行来的也罢。你姓甚么？”猴王又道：“我无性，人若骂我我也不恼，若打我我也不嗔，只是陪个礼儿就罢了，一生无性。”祖师道：“不是这个性。你父母原来姓甚么？”猴王道：“我也无父母。”祖师道：“既无父母，想是树上生的？”猴王道：“我虽不是树上生，却是石里长的。我只记得花果山上有一块仙石，其年石破，我便生也。”祖师闻言暗喜道：“这等说，却是个天地生成的，你起来走走我看。”猴王纵身跳起，拐呀拐的走了两遍。祖师笑道：“你身躯虽是鄙陋，却像个食松果的猢狲。我与你就身上取个姓氏，意思教你姓‘猢’。猢字去了个兽旁，乃是个古月。古者老也，月者阴也；老阴不能化育。教你姓‘狲’倒好。狲字去了兽旁，乃是个子系。子者儿男也，系者婴细也，正合婴儿之本论，教你姓‘孙’罢。”猴王听说，满心欢喜，朝上叩头道：“好！好！好！今日方知姓也。万望师父慈悲，既然有姓，再乞赐个名字，却好呼唤。”祖师道：“我门中有十二个字分派起名，到你乃第十辈之小徒矣。”猴王道：“那十二个字？”祖师道：“乃广大智慧、真如性海、颖悟圆觉十二字。排到你，正当‘悟’字。与你起个法名叫做‘孙悟空’，好么？”猴王笑道：“好！好！好！自今就叫做孙悟空也！”正是鸿蒙初辟原无姓，打破顽空须悟空。毕竟不知向后修些甚么道果，且听下回分解。')");
        db.execSQL("insert into person(name,type,content) values('一千零一夜','2','话表美猴王得了姓名，怡然踊跃，对菩提前作礼启谢。那祖师即命大众引孙悟空出二门外，教他洒扫应对、进退周旋之节。众仙奉行而出，悟空到门外，又拜了大众师兄，就于廊庑之间，安排寝处。次早，与众师兄学言语礼貌，讲经论道，习字焚香，每日如此。闲时即扫地锄园，养花修树，寻柴燃火，挑水运浆，凡所用之物，无一不备，在洞中不觉倏六七年。一日，祖师登坛高坐，唤集诸仙，开讲大道，真个是天花乱坠，地涌金莲。妙演三乘教，精微万法全。慢摇麈尾喷珠玉，响振雷霆动九天。说一会道，讲一会禅，三家配合本如然。开明一字皈诚理，指引无生了性玄。孙悟空在旁闻讲，喜得他抓耳挠腮，眉花眼笑，忍不住手之舞之，足之蹈之。忽被祖师看见，叫孙悟空道：“你在班中怎么颠狂跃舞，不听我讲？”悟空道：“弟子诚心听讲，听到老师父妙音处，喜不自胜，故不觉作此踊跃之状，望师父恕罪！”祖师道：“你既识妙音，我且问你，你到洞中多少时了？”悟空道：“弟子本来懵懂，不知多少时节。只记得灶下无火，常去山后打柴，见一山好桃树，我在那里吃了七次饱桃矣。”祖师道：“那山唤名烂桃山，你既吃七次，想是七年了。你今要从我学些甚么道？”悟空道：“但凭尊师教诲，只是有些道气儿，弟子便就学了。”\n" +
                "\n" +
                "祖师道：“道字门中有三百六十旁门，旁门皆有正果。不知你学那一门哩？”悟空道：“凭尊师意思，弟子倾心听从。”祖师道：“我教你个术字门中之道如何？”悟空道：“术门之道怎么说？”祖师道：“术字门中，乃是些请仙扶鸾，问卜揲蓍，能知趋吉避凶之理。”悟空道：“似这般可得长生么？”祖师道：“不能不能。”悟空道：“不学不学！”\n" +
                "\n" +
                "祖师又道：“教你流字门中之道如何？”悟空又问：“流字门中是甚义理？”祖师道：“流字门中，乃是儒家、释家、道家、阴阳家、墨家、医家，或看经，或念佛，并朝真降圣之类。”悟空道：“似这般可得长生么？”祖师道：“若要长生，也似壁里安柱。”悟空道：“师父，我是个老实人，不晓得打市语。怎么谓之壁里安柱？”祖师道：“人家盖房欲图坚固，将墙壁之间立一顶柱，有日大厦将颓，他必朽矣。”悟空道：“据此说，也不长久，不学不学！”\n" +
                "\n" +
                "祖师道：“教你静字门中之道如何？”悟空道：“静字门中是甚正果？”祖师道：“此是休粮守谷，清静无为，参禅打坐，戒语持斋，或睡功，或立功，并入定坐关之类。”悟空道：“这般也能长生么？”祖师道：“也似窑头土坯。”悟空笑道：“师父果有些滴哒，一行说我不会打市语，怎么谓之窑头土坯？”祖师道：“就如那窑头上造成砖瓦之坯，虽已成形，尚未经水火锻炼，一朝大雨滂沱，他必滥矣。”悟空道：“也不长远，不学不学！”\n" +
                "\n" +
                "祖师道：“教你动字门中之道如何？”悟空道：“动门之道却又怎么？”祖师道：“此是有为有作，采阴补阳，攀弓踏弩，摩脐过气，用方炮制，烧茅打鼎，进红铅，炼秋石，并服妇乳之类。”悟空道：“似这等也得长生么？”祖师道：“此欲长生，亦如水中捞月。”悟空道：“师父又来了！怎么叫做水中捞月？”祖师道：“月在长空，水中有影，虽然看见，只是无捞摸处，到底只成空耳。”悟空道：“也不学不学！”\n" +
                "\n" +
                "祖师闻言，咄的一声，跳下高台，手持戒尺，指定悟空道：“你这猢狲，这般不学，那般不学，却待怎么？”走上前，将悟空头上打了三下，倒背着手，走入里面，将中门关了，撇下大众而去。唬得那一班听讲的，人人惊惧，皆怨悟空道：“你这泼猴，十分无状！师父传你道法，如何不学，却与师父顶嘴？这番冲撞了他，不知几时才出来呵！”此时俱甚报怨他，又鄙贱嫌恶他，悟空一些儿也不恼，只是满脸陪笑。原来那猴王已打破盘中之谜，暗暗在心，所以不与众人争竞，只是忍耐无言。祖师打他三下者，教他三更时分存心；倒背着手走入里面，将中门关上者，教他从后门进步，秘处传他道也。\n" +
                "\n" +
                "当日悟空与众等，喜喜欢欢，在三星洞之前盼望天色，急不能到晚。及黄昏时，却与众就寝，假合眼，定息存神。山中又没打更传箭，不知时分，只自家将鼻孔中出入之气调定。约到子时前后，轻轻的起来，穿了衣服，偷开前门，躲离大')");
        db.execSQL("insert into person(name,type,content) values('爱丽丝梦游奇境记','2','一日，春归夏至，大众都在松树下会讲多时。大众道：“悟空，你是那世修来的缘法？前日老师父附耳低言，传与你的躲三灾变化之法，可都会么？”悟空笑道：“不瞒诸兄长说，一则是师父传授，二来也是我昼夜殷勤，那几般儿都会了。”大众道：“趁此良时，你试演演，让我等看看。”悟空闻说，抖擞精神，卖弄手段道：“众师兄请出个题目，要我变化甚么？”大众道：“就变颗松树罢。”悟空捻着诀，念动咒语，摇身一变，就变成一颗松树，真个是：郁郁含烟贯四时，凌云直上秀贞姿。全无一点妖猴像，尽是经霜耐雪枝。大众见了，鼓掌呵呵大笑，都道：“好猴儿！好猴儿！”不觉的嚷闹，惊动了祖师，祖师急拽杖出门来问道：“是何人在此喧哗？”大众闻呼，慌忙检束，整衣向前。悟空也现了本相，杂在丛中道：“启上尊师，我等在此会讲，更无外姓喧哗。”祖师怒喝道：“你等大呼小叫，全不像个修行的体段！修行的人，口开神气散，舌动是非生，如何在此嚷笑？”大众道：“不敢瞒师父，适才孙悟空演变化耍子。教他变颗松树，果然是颗松树，弟子们俱称扬喝采，故高声惊冒尊师，望乞恕罪。”祖师道：“你等起去。”叫：“悟空过来！我问你弄甚么精神，变甚么松树？这个工夫可好在人前卖弄？假如你见别人有，不要求他？别人见你有，必然求你。你若畏祸，却要传他；若不传他，必然加害，你之性命又不可保。”悟空叩头道：“只望师父恕罪！”祖师道：“我也不罪你，但只是你去罢。”悟空闻此言，满眼堕泪道：“师父，教我往那里去？”祖师道：“你从那里来，便从那里去就是了。”悟空顿然醒悟道：“我自东胜神洲傲来国花果山水帘洞来的。”祖师道：“你快回去，全你性命，若在此间，断然不可！”悟空领罪，上告尊师：“我也离家有二十年矣，虽是回顾旧日儿孙，但念师父厚恩未报，不敢去。”祖师道：“那里甚么恩义？你只不惹祸不牵带我就罢了！”悟空见没奈何，只得拜辞，与众相别，祖师道：“你这去，定生不良。凭你怎么惹祸行凶，却不许说是我的徒弟。你说出半个字来，我就知之，把你这猢狲剥皮锉骨，将神魂贬在九幽之处，教你万劫不得翻身！”悟空道：“决不敢提起师父一字，只说是我自家会的便罢。”\n" +
                "\n" +
                "悟空谢了，即抽身，捻着诀，丢个连扯，纵起筋斗云，径回东胜。那里消一个时辰，早看见花果山水帘洞，美猴王自知快乐，暗暗的自称道：“去时凡骨凡胎重，得道身轻体亦轻。举世无人肯立志，立志修玄玄自明。当时过海波难进，今日回来甚易行。别语叮咛还在耳，何期顷刻见东溟！”悟空按下云头，直至花果山，找路而去，忽听得鹤唳猿啼，鹤唳声冲霄汉外，猿啼悲切甚伤情，即开口叫道：“孩儿们，我来了也！”那崖下石坎边，花草中，树木里，若大若小之猴，跳出千千万万，把个美猴王围在当中，叩头叫道：“大王，你好宽心！怎么一去许久，把我们俱闪在这里，望你诚如饥渴！近来被一妖魔在此欺虐，强要占我们水帘洞府，是我等舍死忘生与他争斗。这些时')");

    }

    /**
     * 数据库升级的时候回调该方法，在数据库版本号DB_VERSION升级的时候才会调用
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //给表添加一个字段
        //db.execSQL("alter table person add age integer");
    }

    /**
     * 数据库打开的时候回调该方法
     *
     * @param db
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.e("zx", "onOpen: ");
    }
}

