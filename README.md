# rxjava_for_android

	Android平台上使用RxJava的Demo
<br/>

![](http://i.imgur.com/iWI5WxY.gif)
![](http://i.imgur.com/vjXS2pI.gif)

<center>...</center>
-----------------------------------------------------------


[博客首页](http://blog.csdn.net/qq1026291832/article/details/51007490 "博客首页")

	1、Rxjava是什么（响应式编程）
       这个问题有很多前辈都已经解答过，如果你真的想了解并去学习RxJava，不妨抛下心中的烦躁（要知道有些东西并不是拿来就能用），耐心的去阅读他们的博客或资料(文章末尾)，我对这个问题的回答肯定没有前辈那么有深度或广度，所以在此就不过多的去阐述其概念。基于自己的理解下一个定义： RxJava是一个使用Java语言基于观察者设计模式拓展而来的响应式编程库。
     
    2、Rxjava能做什么（高效）
        首先我们需要明确，使用RxJava写出的功能，并不会说比普通的Java代码多么强大， 不禁会问：那有什么卵用？（已不止一个小伙伴讽刺过这个答案），当我们真正了解了RxJava以及使用一些便捷的操作符，我们会更深刻的体会到什么是高效。
    
    3、如何学习RxJava（耐心）
        首先请调节好学习心态，RxJava并不是一个”拿来就能用“的项目，他需要我们像学习一门新语言一样从语法-->词汇-->用法的学习过程，不要抱怨他是多么的复杂、国内资料是多么的少。毕竟它只是个不到1MB Jar包大小的库，花不了我们太多时间即可入门，我们需要做的只是摆好心态，耐心的学习。
    
<br/><br/><br/>
###一、入门
   如果你还没有接触过RxJava，下面这些文章可能会帮到你：
   
 [给 Android 开发者的 RxJava 详解 ](http://gank.io/post/560e15be2dca930e00da1083) ——扔物线   对RxJava的概念以及基本特性做了详细介绍
   
   下面这些文章适合你跟着去敲，了解RxJava的基本语法：

[深入浅出RxJava（一：基础篇）](http://blog.csdn.net/lzyzsd/article/details/41833541)

[深入浅出RxJava ( 二：操作符 )](http://blog.csdn.net/lzyzsd/article/details/44094895)

[深入浅出RxJava ( 三--响应式的好处 )](http://blog.csdn.net/lzyzsd/article/details/44891933)

[深入浅出RxJava ( 四-在Android中使用响应式编程 )](http://blog.csdn.net/lzyzsd/article/details/45033611)

——hi大头鬼hi


如果你对RxJava的链式编程和代码结构感到好奇，下面这篇文章会从代码的角度给你带来惊喜：
   
[NotRxJava懒人专用指南 ](http://www.devtf.cn/?p=323)   从代码的角度教你实现一个简易的RxJava库                       
   ——作者：Yaroslav Heriatovych  译者：Rocko  

<br/><br/><br/>
###二、进阶
如果你已了解RxJava基本语法，并尝试着去练习，那么现在你需要熟悉更多的操作符，并理解它们的意思，在特定的场合使用它们去编写代码。

操作符介绍：[ReactiveX中文翻译文档](https://mcxiaoke.gitbooks.io/rxdocs/content/index.html)

以下是网上收集到的RxJava操作符在某些场景下的使用：

[RxJava使用场景小结](http://blog.csdn.net/theone10211024/article/details/50435325)                                        ——THEONE10211024

[RxJava使用场景小结 ](http://blog.csdn.net/lzyzsd/article/details/50120801)                                       ——hi大头鬼hi

[RxJava-Android-Samples ](https://github.com/kaushikgopal/RxJava-Android-Samples)                             ——kaushikgopal


以下是本人在工作之余写的Demo，可github直接下载源码查看

[<b>rxjava-for-android</b>](https://github.com/cn-ljb/rxjava_for_android)    （诺对您有所帮助，还望star）

[（一）RxJava在Android网络框架中的使用](http://blog.csdn.net/qq1026291832/article/details/51006059)

[（二）RxJava+RxBinding在View上的一些使用技巧](http://blog.csdn.net/qq1026291832/article/details/51006145)

[（三）RxJava操作符：Buffer](http://blog.csdn.net/qq1026291832/article/details/51006385)

[（四）RxJava操作符：zip数据合并操作](http://blog.csdn.net/qq1026291832/article/details/51006451)

[（五）RxJava操作符：merge合并操作符](http://blog.csdn.net/qq1026291832/article/details/51006538)

[（六）RxJava轮询器：interval](http://blog.csdn.net/qq1026291832/article/details/51006613)

[（七）RxJava定时器：timer](http://blog.csdn.net/qq1026291832/article/details/51006705)

[（八）RxJava：PublishSubject](http://blog.csdn.net/qq1026291832/article/details/51006746)

[（九）RxJava：RxBus](http://blog.csdn.net/qq1026291832/article/details/51006825)

<br/><br/><br/>
###三、 其他可能对你有所帮助的资料

[那些年我们错过的响应式编程](http://www.devtf.cn/?p=174)        ——很详细的介绍什么是响应式编程

[使用RxJava.Observable取代AsyncTask和AsyncTaskLoader](http://www.devtf.cn/?p=114)    ——通过比较介绍RxJava在异步处理上的优势

[RxJava部分操作符介绍 ](http://mushuichuan.com/tags/RxJava/)       ——水木川博客

[Awesome-RxJava](https://github.com/lzyzsd/Awesome-RxJava)               ——hi大头鬼hi     RxJava资源的总结分享
    
#####值得一读的文章：

[给创业码农的话--如何提升开发效率](http://mp.weixin.qq.com/s?__biz=MzAwNDY1ODY2OQ==&mid=400785752&idx=1&sn=e1c166e7fad0892811c9ca9bca6d1540&scene=23&srcid=0329Nz6yhFIZKbW9emQgjUlM#rd)

[关于APK瘦身值得分享的一些经验](http://zmywly8866.github.io/2015/04/06/decrease-apk-size.html)

[Android客户端性能优化](http://blog.csdn.net/yueqian_scut/article/details/50762649#comments)

<br/><br/><br/>
###四、学习中可能会涉及到的库
<a>https://github.com/ReactiveX/RxJava</a>          ——RxJava核心库

<a>https://github.com/ReactiveX/RxAndroid</a>        ——RxJava在Android中使用的扩展库

<a>https://github.com/JakeWharton/RxBinding</a>    ——Android控件对RxJava的支持库

<a>https://github.com/f2prateek/rx-preferences</a>    ——使SharedPreferences支持
RxJava

<a>https://github.com/trello/RxLifecycle</a>                ——帮助RxJava在Android中生命周期的控制，避免内存溢出等问题

<a>https://github.com/square/retrofit</a>                    ——Retrofit对Rxjava提供支持

<a>https://github.com/pushtorefresh/storio</a>         ——数据库对RxJava的支持
