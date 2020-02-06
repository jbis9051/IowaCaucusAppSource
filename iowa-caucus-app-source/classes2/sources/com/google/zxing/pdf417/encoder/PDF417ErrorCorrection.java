package com.google.zxing.pdf417.encoder;

import com.google.logging.type.LogSeverity;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAESCBC;
import io.sentry.connection.HttpConnection;
import org.reactnative.camera.Constants;

final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS;

    static {
        int[] iArr = new int[CipherStorageKeystoreAESCBC.ENCRYPTION_KEY_SIZE];
        // fill-array-data instruction
        iArr[0] = 524;
        iArr[1] = 894;
        iArr[2] = 75;
        iArr[3] = 766;
        iArr[4] = 882;
        iArr[5] = 857;
        iArr[6] = 74;
        iArr[7] = 204;
        iArr[8] = 82;
        iArr[9] = 586;
        iArr[10] = 708;
        iArr[11] = 250;
        iArr[12] = 905;
        iArr[13] = 786;
        iArr[14] = 138;
        iArr[15] = 720;
        iArr[16] = 858;
        iArr[17] = 194;
        iArr[18] = 311;
        iArr[19] = 913;
        iArr[20] = 275;
        iArr[21] = 190;
        iArr[22] = 375;
        iArr[23] = 850;
        iArr[24] = 438;
        iArr[25] = 733;
        iArr[26] = 194;
        iArr[27] = 280;
        iArr[28] = 201;
        iArr[29] = 280;
        iArr[30] = 828;
        iArr[31] = 757;
        iArr[32] = 710;
        iArr[33] = 814;
        iArr[34] = 919;
        iArr[35] = 89;
        iArr[36] = 68;
        iArr[37] = 569;
        iArr[38] = 11;
        iArr[39] = 204;
        iArr[40] = 796;
        iArr[41] = 605;
        iArr[42] = 540;
        iArr[43] = 913;
        iArr[44] = 801;
        iArr[45] = 700;
        iArr[46] = 799;
        iArr[47] = 137;
        iArr[48] = 439;
        iArr[49] = 418;
        iArr[50] = 592;
        iArr[51] = 668;
        iArr[52] = 353;
        iArr[53] = 859;
        iArr[54] = 370;
        iArr[55] = 694;
        iArr[56] = 325;
        iArr[57] = 240;
        iArr[58] = 216;
        iArr[59] = 257;
        iArr[60] = 284;
        iArr[61] = 549;
        iArr[62] = 209;
        iArr[63] = 884;
        iArr[64] = 315;
        iArr[65] = 70;
        iArr[66] = 329;
        iArr[67] = 793;
        iArr[68] = 490;
        iArr[69] = 274;
        iArr[70] = 877;
        iArr[71] = 162;
        iArr[72] = 749;
        iArr[73] = 812;
        iArr[74] = 684;
        iArr[75] = 461;
        iArr[76] = 334;
        iArr[77] = 376;
        iArr[78] = 849;
        iArr[79] = 521;
        iArr[80] = 307;
        iArr[81] = 291;
        iArr[82] = 803;
        iArr[83] = 712;
        iArr[84] = 19;
        iArr[85] = 358;
        iArr[86] = 399;
        iArr[87] = 908;
        iArr[88] = 103;
        iArr[89] = 511;
        iArr[90] = 51;
        iArr[91] = 8;
        iArr[92] = 517;
        iArr[93] = 225;
        iArr[94] = 289;
        iArr[95] = 470;
        iArr[96] = 637;
        iArr[97] = 731;
        iArr[98] = 66;
        iArr[99] = 255;
        iArr[100] = 917;
        iArr[101] = 269;
        iArr[102] = 463;
        iArr[103] = 830;
        iArr[104] = 730;
        iArr[105] = 433;
        iArr[106] = 848;
        iArr[107] = 585;
        iArr[108] = 136;
        iArr[109] = 538;
        iArr[110] = 906;
        iArr[111] = 90;
        iArr[112] = 2;
        iArr[113] = 290;
        iArr[114] = 743;
        iArr[115] = 199;
        iArr[116] = 655;
        iArr[117] = 903;
        iArr[118] = 329;
        iArr[119] = 49;
        iArr[120] = 802;
        iArr[121] = 580;
        iArr[122] = 355;
        iArr[123] = 588;
        iArr[124] = 188;
        iArr[125] = 462;
        iArr[126] = 10;
        iArr[127] = 134;
        iArr[128] = 628;
        iArr[129] = 320;
        iArr[130] = 479;
        iArr[131] = 130;
        iArr[132] = 739;
        iArr[133] = 71;
        iArr[134] = 263;
        iArr[135] = 318;
        iArr[136] = 374;
        iArr[137] = 601;
        iArr[138] = 192;
        iArr[139] = 605;
        iArr[140] = 142;
        iArr[141] = 673;
        iArr[142] = 687;
        iArr[143] = 234;
        iArr[144] = 722;
        iArr[145] = 384;
        iArr[146] = 177;
        iArr[147] = 752;
        iArr[148] = 607;
        iArr[149] = 640;
        iArr[150] = 455;
        iArr[151] = 193;
        iArr[152] = 689;
        iArr[153] = 707;
        iArr[154] = 805;
        iArr[155] = 641;
        iArr[156] = 48;
        iArr[157] = 60;
        iArr[158] = 732;
        iArr[159] = 621;
        iArr[160] = 895;
        iArr[161] = 544;
        iArr[162] = 261;
        iArr[163] = 852;
        iArr[164] = 655;
        iArr[165] = 309;
        iArr[166] = 697;
        iArr[167] = 755;
        iArr[168] = 756;
        iArr[169] = 60;
        iArr[170] = 231;
        iArr[171] = 773;
        iArr[172] = 434;
        iArr[173] = 421;
        iArr[174] = 726;
        iArr[175] = 528;
        iArr[176] = 503;
        iArr[177] = 118;
        iArr[178] = 49;
        iArr[179] = 795;
        iArr[180] = 32;
        iArr[181] = 144;
        iArr[182] = 500;
        iArr[183] = 238;
        iArr[184] = 836;
        iArr[185] = 394;
        iArr[186] = 280;
        iArr[187] = 566;
        iArr[188] = 319;
        iArr[189] = 9;
        iArr[190] = 647;
        iArr[191] = 550;
        iArr[192] = 73;
        iArr[193] = 914;
        iArr[194] = 342;
        iArr[195] = 126;
        iArr[196] = 32;
        iArr[197] = 681;
        iArr[198] = 331;
        iArr[199] = 792;
        iArr[200] = 620;
        iArr[201] = 60;
        iArr[202] = 609;
        iArr[203] = 441;
        iArr[204] = 180;
        iArr[205] = 791;
        iArr[206] = 893;
        iArr[207] = 754;
        iArr[208] = 605;
        iArr[209] = 383;
        iArr[210] = 228;
        iArr[211] = 749;
        iArr[212] = 760;
        iArr[213] = 213;
        iArr[214] = 54;
        iArr[215] = 297;
        iArr[216] = 134;
        iArr[217] = 54;
        iArr[218] = 834;
        iArr[219] = 299;
        iArr[220] = 922;
        iArr[221] = 191;
        iArr[222] = 910;
        iArr[223] = 532;
        iArr[224] = 609;
        iArr[225] = 829;
        iArr[226] = 189;
        iArr[227] = 20;
        iArr[228] = 167;
        iArr[229] = 29;
        iArr[230] = 872;
        iArr[231] = 449;
        iArr[232] = 83;
        iArr[233] = 402;
        iArr[234] = 41;
        iArr[235] = 656;
        iArr[236] = 505;
        iArr[237] = 579;
        iArr[238] = 481;
        iArr[239] = 173;
        iArr[240] = 404;
        iArr[241] = 251;
        iArr[242] = 688;
        iArr[243] = 95;
        iArr[244] = 497;
        iArr[245] = 555;
        iArr[246] = 642;
        iArr[247] = 543;
        iArr[248] = 307;
        iArr[249] = 159;
        iArr[250] = 924;
        iArr[251] = 558;
        iArr[252] = 648;
        iArr[253] = 55;
        iArr[254] = 497;
        iArr[255] = 10;
        EC_COEFFICIENTS = new int[][]{new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, LogSeverity.EMERGENCY_VALUE, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, 511, LogSeverity.WARNING_VALUE, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, 605, 158, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, LogSeverity.WARNING_VALUE, 925, 749, 415, 822, 93, 217, 208, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, Constants.LANDSCAPE_270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, LogSeverity.CRITICAL_VALUE, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, iArr, new int[]{352, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, LogSeverity.EMERGENCY_VALUE, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, 258, 240, 518, 794, 395, 768, 848, 51, 610, 384, 168, 190, 826, 328, 596, 786, 303, 570, 381, 415, 641, 156, 237, 151, HttpConnection.HTTP_TOO_MANY_REQUESTS, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, 158, 209, 563, 564, 343, 693, 109, 608, 563, 365, 181, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, 305, 441, 207, LogSeverity.NOTICE_VALUE, 892, 827, 141, 537, 381, 662, 513, 56, 252, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, 273, 610, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, 424, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, 486, 721, 610, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, LogSeverity.CRITICAL_VALUE, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, 410, 389, 244, 31, 121, 303, 263}};
    }

    private PDF417ErrorCorrection() {
    }

    static int getErrorCorrectionCodewordCount(int i) {
        if (i >= 0 && i <= 8) {
            return 1 << (i + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (i <= 40) {
            return 2;
        } else {
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
    }

    static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            if (cArr[i4] != 0) {
                cArr[i4] = (char) (929 - cArr[i4]);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }
}
