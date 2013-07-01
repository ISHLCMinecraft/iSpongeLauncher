package ISHLC.iplugins;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class pListener implements Listener{

  ArrayList<Player> launched = new ArrayList<Player>();
	ArrayList<Player> jumped = new ArrayList<Player>();
	
	Main plugin;
	
	public pListener(Main m){
		plugin = m;
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(e.getCause().equals(DamageCause.FALL)){
				if(jumped.contains(p)){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		final Player p = e.getPlayer();
		final Location l = e.getTo();
		if(p.isOnGround()){
			Block sponge = l.add(0, -1, 0).getBlock();
			if(sponge.getType().equals(Material.SPONGE)){
				Block sign = sponge.getLocation().add(0, -1, 0).getBlock();
				if(sign.getType().equals(Material.SIGN) || sign.getType().equals(Material.SIGN_POST) || sign.getType().equals(Material.WALL_SIGN)){
					final Sign s = (Sign) sign.getState();
					if(!jumped.contains(p)){
						Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
							public void run(){
								if(!jumped.contains(p) && !jumped.contains(p)){
									String line1 = s.getLine(0);
									String line2 = s.getLine(1);
									String line3 = s.getLine(2);
									String line4 = s.getLine(3);
									String lines = line1 + line2 + line3 + line4;
									char[] dir = lines.toCharArray();
									setVelocity(p, dir, 0, false, true);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.MOBSPAWNER_FLAMES, 10);
									
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.ENDER_SIGNAL, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.ENDER_SIGNAL, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.ENDER_SIGNAL, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.ENDER_SIGNAL, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.ENDER_SIGNAL, 10);
									l.getWorld().playEffect(l.add(0, 0.1, 0), Effect.ENDER_SIGNAL, 10);
									
									launched.add(p);
									Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
										public void run() {
											launched.remove(p);
											jumped.add(p);
										}
									}, 3L);
								}
							}
						}, 1L);
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void setVelocity(final Player p, final char[] charArray, final int i, final boolean im, final boolean force) {
		if(!(i > charArray.length)){
			if(jumped.contains(p) || force || launched.contains(p)){
				if(!(charArray[i] == ' ')){
					final int in = i + 1;
					char v = charArray[i];
					if((v + "").toUpperCase().charAt(0) == 'R'){
						try {
							p.setVelocity(new Vector(0, 0, 0));
							setVelocity(p, charArray, in, im, false);
						} catch (Exception e) {
							
						}
					} else if((v + "").toUpperCase().charAt(0) == 'U'){
						p.setVelocity((p.getVelocity().setY(1)));
						if(!im){
							Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
								public void run() {
									try {
										setVelocity(p, charArray, in, im, false);
									} catch (Exception e) {
										
									}
								}
							}, 7L);
						} else {
							try {
								setVelocity(p, charArray, in, im, false);
							} catch (Exception e) {
								
							}
						}
					} else if((v + "").toUpperCase().charAt(0) == 'D'){
						p.setVelocity((p.getVelocity().setY(-1)));
						if(!im){
							Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
								public void run() {
									try {
										setVelocity(p, charArray, in, im, false);
									} catch (Exception e) {
										
									}
								}
							}, 7L);
						} else {
							try {
								setVelocity(p, charArray, in, im, false);
							} catch (Exception e) {
								
							}
						}
					} else if((v + "").toUpperCase().charAt(0) == '0'){
						p.setVelocity(new Vector(p.getVelocity().getX(), p.getVelocity().getY(), 1));
						if(!im){
							Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
								public void run() {
									try {
										setVelocity(p, charArray, in, im, false);
									} catch (Exception e) {
										
									}
								}
							}, 7L);
						} else {
							try {
								setVelocity(p, charArray, in, im, false);
							} catch (Exception e) {
								
							}
						}
					} else if((v + "").toUpperCase().charAt(0) == '2'){
						p.setVelocity(new Vector(p.getVelocity().getX(), p.getVelocity().getY(), -1));
						if(!im){
							Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
								public void run() {
									try {
										setVelocity(p, charArray, in, im, false);
									} catch (Exception e) {
										
									}
								}
							}, 7L);
						} else {
							try {
								setVelocity(p, charArray, in, im, false);
							} catch (Exception e) {
								
							}
						}
					} else if((v + "").toUpperCase().charAt(0) == '1'){
						p.setVelocity(new Vector(-1, p.getVelocity().getY(), p.getVelocity().getZ()));
						if(!im){
							Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
								public void run() {
									try {
										setVelocity(p, charArray, in, im, false);
									} catch (Exception e) {
										
									}
								}
							}, 7L);
						} else {
							try {
								setVelocity(p, charArray, in, im, false);
							} catch (Exception e) {
								
							}
						}
					} else if((v + "").toUpperCase().charAt(0) == '3'){
						p.setVelocity(new Vector(1, p.getVelocity().getY(), p.getVelocity().getZ()));
						if(!im){
							Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
								public void run() {
									try {
										setVelocity(p, charArray, in, im, false);
									} catch (Exception e) {
										
									}
								}
							}, 7L);
						} else {
							try {
								setVelocity(p, charArray, in, im, false);
							} catch (Exception e) {
								
							}
						}
					} else if((v + "").toUpperCase().charAt(0) == 'W'){
						Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
							public void run() {
								try {
									setVelocity(p, charArray, in, im, false);
								} catch (Exception e) {
									
								}
							}
						}, 7L);
					} else if((v + "").toUpperCase().charAt(0) == 'L'){
						p.setVelocity(p.getLocation().getDirection().multiply(1.5));
						if(!im){
							Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
								public void run() {
									try {
										setVelocity(p, charArray, in, im, false);
									} catch (Exception e) {
										
									}
								}
							}, 7L);
						} else {
							try {
								setVelocity(p, charArray, in, im, false);
							} catch (Exception e) {
								
							}
						}
					} else if((v + "").toUpperCase().charAt(0) == 'I'){
						if(im){
							Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
								public void run() {
									try {
										setVelocity(p, charArray, in, false, false);
									} catch (Exception e) {
										
									}
								}
							}, 7L);
						} else {
							try {
								setVelocity(p, charArray, in, true, false);
							} catch (Exception e) {
								
							}
						}
					}
				}
			} else {
				setVelocity(p, charArray, i + 1, im, false);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLand(final PlayerMoveEvent e){
		if(!e.getFrom().getBlock().equals(e.getTo().getBlock())){
			final Player p = e.getPlayer();
			if(e.getTo().getBlock().getType().equals(Material.AIR)){
				if(!launched.contains(p)){
					if(jumped.contains(p)){
						p.setFallDistance(0);
						Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
							public void run() {
								if(e.getTo().getBlock().getType().equals(Material.AIR)){
									jumped.remove(p);
								}
							}
						}, 3L);
					}
				}
			}
		}
	}
}
