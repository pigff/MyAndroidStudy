package com.example.lin.myandroidapplication.widget.qijian.porter1;

/**
 * PorterDuffXfermode 相关参数  只记录相对简单的公式 0-0
 * -- --- --- ---
 * Mode.ADD Satureate(S + D)   饱和度相加 ADD模式简单来说就是对SRC与DST两张图片相交区域的饱和度进行相加
 * Mode.LIGHTEN 只有重合区域才有变亮的效果
 * Mode.DARKEN 只有重合区域才有变暗效果
 * Mode.MULTIPLY [Sa * Da, Sc * Dc]  所以源图像的非相交区域在计算后是透明的。 在两个区域的相交区域的混合方式是与photoshop中的正片叠底效果是一致的
 * Mode.OVERLAY
 * Mode.SCREEN [Sa + Da - Sa * Da, Sc + Dc - Sc * Dc] 滤色   只是源图像与目标图像交合部分有效果
 *
 * Mode.SRC [Sa, Sc] 全部以源图像显示
 * Mode.SRC_IN[Sa * Da, Sc * Da] 在这个公式中结果值的透明度都是由Sa，Sc分别乘以目标图像的Da来计算的。所以
 * 当目标图像为空白像素时，计算结果也为空白像素。
 * Mode.SRC_OUT[Sa * (1 - Da), Sc * (1 - Da)] 这个模式的特性可以概括为：以目标图像的透明度的补值来调节源图像的透明度和色彩饱和度。
 * 即当目标图像为空白像素时，就完全显示源图像，当目标图像的透明度为100%时，交合区域为空像素。
 * Mode.SRC_OVER
 * Mode.SRC_ATOP[Da, Sc * Da + (1 - Sa) * Dc] 透明度只有100%和0%时，SRC_ATOP和SRC_IN是通用的
 * 当透明度不只有100%和0%时，SRC_ATOP相比SRC_IN源图像的饱和度会增加，即会显得更亮。
 *
 */

public interface PorterInterface {
}
