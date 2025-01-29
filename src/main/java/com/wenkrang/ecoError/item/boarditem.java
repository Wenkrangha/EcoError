package com.wenkrang.ecoError.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class boarditem {
    //背景
    public static ItemStack background_item() {
        ItemStack itemStack = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("");
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
    //背景
    public static ItemStack borad_head() {
        ItemStack itemStack = new ItemStack(Material.BIRCH_SIGN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("§f紧急§9公告");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("§7在一个平静的MC服务器之夜，突如其来的神秘力量席卷了整个虚拟世界。");
        arrayList.add("§7玩家们惊恐地发现，他们辛苦积攒的所有财富、珍贵的红包瞬间消失得无");
        arrayList.add("§7影无踪，所有的商店停止运营，服务器内的经济系统陷入了前所未有的瘫");
        arrayList.add("§7痪。面对这突如其来的变故，玩家们心中充满了疑惑与不安。");
        arrayList.add("§7为了揭开真相，找回失去的一切，玩家们自发组织起来，开始了一场前所");
        arrayList.add("§7未有的探索之旅。他们利用手中的资源，精心制作图册，并使用相机捕捉");
        arrayList.add("§7每一个可能与新年有关的线索，试图从中找到解决问题的关键。通过不懈");
        arrayList.add("§7的努力和详细的分析，玩家们逐渐将目光锁定在了一个神秘的位置——那");
        arrayList.add("§7里似乎是所有问题的源头");
        arrayList.add("§7当玩家们小心翼翼地靠近这个位置时，惊讶地发现了年兽的身影。原来，");
        arrayList.add("§7这一切混乱的始作俑者竟是传说中的年兽，它似乎想要通过破坏服务器的");
        arrayList.add("§7经济来制造恐慌。面对这一挑战，玩家们没有退缩，而是团结一致，共同");
        arrayList.add("§7制定了抵抗计划。经过一场激烈的对抗，他们最终成功击败了年兽，夺回");
        arrayList.add("§7了自己的财产。");
        arrayList.add("§7随着年兽的失败，服务器终于恢复了往日的和平与繁荣。这次经历不仅让");
        arrayList.add("§7玩家们更加珍惜自己的劳动成果，也加深了彼此之间的友谊与合作精神。");
        arrayList.add("§7从此以后，每当新年的钟声敲响，玩家们都会回忆起这段难忘的冒险，提");
        arrayList.add("§7醒自己勇敢面对未知的挑战。");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack head_sure() {
        ItemStack itemStack = new ItemStack(Material.ANVIL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("§f我已经阅读了左边的§9公告");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("§7我已经阅读了左边的公告在右边获取图");
        arrayList.add("§7册和相机");
        arrayList.add("");
        arrayList.add("§7公告简单版：服务器经济被年兽搞没了，现在要完成图册里面");
        arrayList.add("§7的任务才可以修好，最后还要打boss,才可以修好，最后还要");
        arrayList.add("§7打boss");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack get_book() {
        ItemStack itemStack = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("§f获取§9图册");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("§7点击我获取图册,你可以通过提交图片(用左");
        arrayList.add("§7边的相机拍)来完成图册里面的任务");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack get_camara() {
        ItemStack itemStack = new ItemStack(Material.OBSERVER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("§f获取§9相机");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("§7点击我获取相机,你可以用相机拍下任务中");
        arrayList.add("§7的要求东西,来提交图册里面的任务");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack getsure() {
        ItemStack itemStack = new ItemStack(Material.OBSERVER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setItemName("§f关闭§9界面");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("§7我已经阅读完了公告，我需要关闭界面");
        arrayList.add("§7在左边获取图册和相机，开启你的活动之旅吧！");
        itemMeta.setLore(arrayList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


}
