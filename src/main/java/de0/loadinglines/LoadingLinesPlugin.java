package de0.loadinglines;

import javax.inject.Inject;

import com.google.inject.Provides;

import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(name = "Loading Lines", description = "Draw loading lines on screen", enabledByDefault = false)
public class LoadingLinesPlugin extends Plugin {

  @Inject
  private OverlayManager overlayManager;

  @Inject
  private LoadingLinesOverlay overlay;

  @Inject
  private LoadingLinesMinimapOverlay minimapOverlay;

  @Inject
  private LoadingLinesWorldmapOverlay worldmapOverlay;

  @Provides
  LoadingLinesConfig provideConfig(ConfigManager configManager) {
    return configManager.getConfig(LoadingLinesConfig.class);
  }

  @Override
  protected void startUp() throws Exception {
    overlayManager.add(overlay);
    overlayManager.add(minimapOverlay);
    overlayManager.add(worldmapOverlay);
  }

  @Override
  protected void shutDown() throws Exception {
    overlayManager.remove(overlay);
    overlayManager.remove(minimapOverlay);
    overlayManager.remove(worldmapOverlay);
  }

}
