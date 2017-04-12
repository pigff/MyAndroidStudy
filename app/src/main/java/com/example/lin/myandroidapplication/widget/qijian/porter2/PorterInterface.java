package com.example.lin.myandroidapplication.widget.qijian.porter2;

/**
 * PorterDuffXfermode 相关参数  只记录相对简单的公式 0-0
 * -- --- --- ---
 * Mode.DST[Da, Dc] 全部以目标图像显示
 * Mode.DST_IN[Da * Sa, Dc * Sa]是在相交时利用源图像的透明度来改变目标图像的透明度和饱和度
 * Mode.DST_OUT[Da * (1 - Sa), Dc * (1 - Sa)]当源图像透明度是100%时，则相交区域为空值。当源图像透明度为0时，
 * 则完全显示目标图像。非相交区域完全显示目标图像。
 * Mode.DST_OVER 显示DST图像为主
 * Mode.DST_ATOP
 *
 * 1.DST相关模式是完全可以使用SRC对应的模式来实现的，只不过需要将目标图像和原图像对调一下即可。
 * 2.在SRC模式中，是以显示源图像为主，通过目标图像的透明度来调节计算结果的透明度和饱和度，而在DST模式中，
 * 是以显示目标图像为主，通过源图像的透明度来调节计算结果的透明度和饱和度
 *
 * Mode.CLEAR[0,0] 清空源图像所在的区域
 * Mode.XOR
 *
 * 在实际应用中，我们可以从下面三个方面来决定使用哪一种模式：
 * 1.首先，目标图像和源图像混合，需不需要生成颜色的叠加特效，如果需要叠加特效则从颜色叠加相关模式中选择，
 * 有Mode.ADD(饱和度相加)、Mode.DARKEN(变暗),Mode.LIGHTEN(变亮),Mode.MULTIPLY(正片叠底),Mode.OVERLAY(叠加),Mode.SCREEN(滤色)
 * 2.当不需要特效，而需要根据某一张图像的透明像素来裁剪时，就需要使用SRC相关模式或DST相关模式了。由于SRC相关模式与DST相关模式是相同的，
 * 唯一不同的是决定当前哪个是目标图像和源图像。
 * 3.当需要清空源图像时，使用Mode.CLEAR
 */

public interface PorterInterface {

}
