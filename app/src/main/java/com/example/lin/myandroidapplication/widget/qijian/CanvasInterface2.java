package com.example.lin.myandroidapplication.widget.qijian;

/**
 * 绘图篇 - 十四 Canvas与图层(二)
 * 主要是记录博客的内容
 * ----- ------- ------
 * http://blog.csdn.net/harvic880925/article/details/51332494
 */

public interface CanvasInterface2 {

    /**
     * 1. save系列函数(save、saveLayer、saveLayerAlpha) 都具有Flag标识，意义和使用范围如下：
     *              FLAG                            意义                              适用范围
     *       ALL_SAVE_FLAG                       保存所有标识                        save、saveLayer
     *       MATRIX_SAVE_FLAG                仅保存canvas的matrix数组                save、saveLayer
     *       CLIP_SAVE_FLAG                  仅保存canvas的当前大小                   save、saveLayer
     *       HAS_ALPHA_LAYER_SAVE_FLAG       标识新建的bmp具有透明度，                 saveLayer
     *                                       在于上层画布结合时，透明位置
     *                                       显示上层图像。优先级高
     *
     *       HAS_COLOR_LAYER_SAVE_FLAG       标识新建的bmp颜色完全独立，在与            saveLayer
     *                                       上层画布结合时先清空上层画布再
     *                                       覆盖上去。
     *
     *       CLIP_TO_LAYER_SAVE_FLAG         在保存图层前先把当前画布根据bounds裁剪，    saveLayer
     *                                       与Clip_SAVE_FLAG冲突，若同时指定，则
     *                                       以CLIP_SAVE_FLAG为主
     *
     *     MATRIX_SAVE_FLAG结论1.当save、saveLayer调用Canvas.MATRIX_SAVE_FLAG标识只会保存画布的位置矩阵信息，
     *     在canvas.restore()时也只会恢复位置信息，而改变过得画布大小是不会被恢复的。
     *     结论2.当使用canvas.saveLayer(Canvas.MATRIX_SAVE_FLAG)时，需要与Canvas.HAS_ALPHA_LAYER_SAVE_FLAG
     *     一起使用，不然新建画布所在区域原来的图像将被清空。
     *
     *     CLIP_SAVE_FLAG结论1.当save、saveLayer调用Canvas.CLIP_SAVE_FLAG时只会保存画布的裁剪信息，在canvas.restore()
     *     时也只会恢复裁剪信息，而改变过得画布位置信息是不会被恢复的。
     *     2.当使用canvas.saveLayer(Canvas.CLIP_SAVE_FLAG)时，需要与Canvas.HAS_ALPHA_LAYER_SAVE_FLAG一起使用，
     *     不然新建画布所在区域原来的图像将被清空。
     *
     *     1.HAS_ALPHA_LAYER_SAVE_FLAG表示新建的bitmap画布在与上一个画布合成时，不会将上一层画布内容清空，直接盖在上一个
     *     画布内容上面。
     *     2.FULL_COLOR_LAYER_SAVE_FLAG则表示新建的bitmap画布在与上一个画布合成时，先将上一层画布对应区域清空，然后盖在上面。
     *     3.当HAS_ALPHA_LAYER_SAVE_FLAG与FULL_COLOR_LAYER_SAVE_FLAG两个标识同时指定时，以HAS_ALPHA_LAYER_SAVE_FLAG
     *     为主。
     *     4.当即没有指定HAS_ALPHA_LAYER_SAVE_FLAG也没有指定FULL_COLOR_LAYER时，系统默认使用FULL_COLOR_LAYER_SAVE_FLAG。
     *
     *     CLIP_TO_LAYER_SAVE_FLAG结论1.CLIP_TO_LAYER_SAVE_FLAG意义是新建bitmap前，先把canvas给裁剪，一旦画板被裁剪，那么
     *     其中的各个画布都会被受影响。而且由于它是在新建bitmap前做的裁剪，所以是无法恢复的。
     *     2.当CLIP_TO_LAYER_SAVE_FLAG与CLIP_SAVE_FLAG标识共用时，在调用restore()后，画布将被恢复。
     *
     *     FLAG之ALL_SAVE_FLAG：
     *     对于save(int flag)来讲，ALL_SAVE_FLAG=MATRIX_SAVE_FLAG|CLIP_SAVE_FLAG;即保存位置信息和裁剪信息。
     *     对于saveLayer(int flag)来讲，ALL_SAVE_FLAG=MATRIX_SAVE_FLAG|CLIP_SAVE_FLAG|HAS_ALPHA_LAYER_SAVE_FLAG。
     *     即保存位置信息，和裁剪信息。新建画布在与上一层画布合成时，不清空画布内容。
     */

    /**
     * 所以restore()与restoreToCount(int count)结论
     * 1.restore的意义是把回退栈中的最上层画布状态出栈，恢复画布状态。restoreToCount(int count)的意义是一直退栈，直到指定
     * 层count作为栈顶，将此前所有动作都恢复
     * 2.所以无论哪种save方法，哪个FLAG标识，保存画布时都使用同一个栈。
     * 3.restore与restoreToCount针对的都是同一个栈，所以是完全可以通用和混用。
     *
     */
}
