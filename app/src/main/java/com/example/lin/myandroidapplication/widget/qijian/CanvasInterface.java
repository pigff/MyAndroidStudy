package com.example.lin.myandroidapplication.widget.qijian;

/**
 * 绘图篇 - 十三 Canvas与图层(一)
 * 主要是记录博客的内容
 * ----- ------- ------
 * http://blog.csdn.net/harvic880925/article/details/51317746
 */

public interface CanvasInterface {
    /**
     * 1.onDraw、dispatchDraw区别
     * onDraw的意思是绘制视图自身
     * dispatchDraw是绘制子视图
     * 无论是View还是ViewGroup对它们俩的调用顺序都是onDraw()->dispatchDraw()
     * 但在Viewgroup中，当它有北京的时候就会调用onDraw()方法，否则会跳过onDraw()直接调用dispatchDraw()
     * 所以如果要在ViewGroup中绘图时，往往是重写dispatchDraw()方法
     * 在View中，onDraw()和dispatchDraw()都会调用的，所以我们无论把绘图代码放在onDraw()或者dispatchDraw()中都是可以得到效果的
     * ，但是由于dispatchDraw()的含义是绘制子控件，所以原则上来讲，在绘制View控件时，我们是重新onDraw()函数
     * 结论: 在绘制View控件时，需要重写onDraw()函数，在绘制ViewGroup时，需要重写dispatchDraw()函数
     */

    /**
     * 2.如果我们用Bitmap构造了一个canvas，那这个canvas上绘制的图像也都会保存在这个bitmap上，而不是画在View上，
     * 如果想画在View上就必须使用onDraw(Canvas canvas)函数中传进来的canvas画一遍bitmap才能画到view上。
     */

    /**
     * 3.saveLayer会创建一个全新透明的bitmap，大小与指定保存的区域一致，其后的绘图操作都放在这个bitmap上进行。
     * 在绘制结束后，会直接盖在上一层的bitmap上显示。
     */

    /**
     * 4.图层与画布：
     * 图层(Layer)：每一次调用canvas.drawXXX系列函数时候，都会生成一个透明图层来专门画这个图形。
     * 画布(bitmap)：每一个画布都是bitmap，所有的图像都是画在bitmap上的！我们知道每一次滴啊用canva.drawXXX函数时，
     * 都会生成一个专用的透明图层来画这个图形，画完之后，就盖在画布上。所以如果我们连续调用五个draw函数，那么就会生成五个透明图层，
     * 画完之后依次盖在画布上显示。
     * 画布有两种，第一种是view的原始画布，是通过onDraw(Canvas canvas)函数传进来的，其中参数中的canvas就对应的是view的原始画布，
     * 控件的背景就是画在这个画布上的！
     * 另一种是人造画布，通过savelayer、new Canvas(bitmap)这些方法来人为新建一个画布。尤其是savelayer，
     * 一旦调用saveLayer来新建一个画布以后，以后的所有draw函数所画的图像都是画在这个画布上的，只有当调用restore、restorToCount函数以后
     * 才会返回到原始画布上绘制。
     * Canvas: 这个概念比较难理解，我们可以把Canvas理解成画板，Bitmap理解成透明图纸，而Layer则理解成图层。
     * 每一个draw函数都对应一个图层，在一个图形画完以后，就放在画纸上显示。而一张张透明的图纸则一层层地叠加在画板上显示出来。
     * 我们知道画板和画纸都是用夹子夹在一起的，所以当我们旋转画板时，所有画纸都会跟着旋转！当我们把整个画板裁小时，所有的画纸也都会变小了！
     *
     *
     * save()、saveLayer()、saveLayerAlpha()  三种方法
     */


}
