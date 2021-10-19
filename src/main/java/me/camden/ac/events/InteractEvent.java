package me.camden.ac.events;

import net.b0at.api.event.Event;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class InteractEvent extends Event {
    private final Player player;
    private ItemStack item;
    private Action action;
    private Block blockClicked;
    private BlockFace blockFace;
    private org.bukkit.event.Event.Result useClickedBlock;
    private org.bukkit.event.Event.Result useItemInHand;
    private EquipmentSlot hand;

    public InteractEvent(Player player, ItemStack item, Action action, Block blockClicked, BlockFace blockFace, org.bukkit.event.Event.Result useClickedBlock, org.bukkit.event.Event.Result useItemInHand, EquipmentSlot hand) {
        this.player = player;
        this.item = item;
        this.action = action;
        this.blockClicked = blockClicked;
        this.blockFace = blockFace;
        this.useClickedBlock = useClickedBlock;
        this.useItemInHand = useItemInHand;
        this.hand = hand;
    }

    public Player getPlayer() {
        return player;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Block getBlockClicked() {
        return blockClicked;
    }

    public void setBlockClicked(Block blockClicked) {
        this.blockClicked = blockClicked;
    }

    public BlockFace getBlockFace() {
        return blockFace;
    }

    public void setBlockFace(BlockFace blockFace) {
        this.blockFace = blockFace;
    }

    public org.bukkit.event.Event.Result getUseClickedBlock() {
        return useClickedBlock;
    }

    public void setUseClickedBlock(org.bukkit.event.Event.Result useClickedBlock) {
        this.useClickedBlock = useClickedBlock;
    }

    public org.bukkit.event.Event.Result getUseItemInHand() {
        return useItemInHand;
    }

    public void setUseItemInHand(org.bukkit.event.Event.Result useItemInHand) {
        this.useItemInHand = useItemInHand;
    }

    public EquipmentSlot getHand() {
        return hand;
    }

    public void setHand(EquipmentSlot hand) {
        this.hand = hand;
    }
}
