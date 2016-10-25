# easypr4j
======

Introduction 简介
------------
easypr4j是[liuruoze/EasyPR](https://github.com/liuruoze/EasyPR) 的Java版本。
由于[fan-wenjie/EasyPR-Java](https://github.com/fan-wenjie/EasyPR-Java) 版本无法使用Maven 需要手动加载jar，所以修改了一个maven 版本的
EasyPR是一个中文的开源车牌识别系统，其目标是成为一个简单、高效、准确的车牌识别引擎。

假设我们有如下的原始图片，需要识别出中间的车牌字符与颜色：

![EasyPR 原始图片](res/image/test_image/plate_recognize.jpg)

经过EasyPR的第一步处理车牌检测（PlateDetect）以后，我们获得了原始图片中仅包含车牌的图块：

![EasyPR 车牌](res/image/test_image/chars_segment.jpg)

接着，我们对图块进行OCR过程，在EasyPR中，叫做字符识别（CharsRecognize）。我们得到了一个包含车牌颜色与字符的字符串：

“蓝牌：苏EUK722”
 



