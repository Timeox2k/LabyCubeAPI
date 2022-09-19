LabyCubeAPI - Inofficial Labymod Server API with Support for latest Spigot Versions (1.19.2+)


## Code Example

```java

    //LIST NEEDED TO PREVENT DUPLICATED EVENT CALLS
    private List<Player> labymodPlayers = new ArrayList<>();

    @EventHandler
    public void on(LabymodUserJoinEvent event) {
        final Player player = event.getPlayer();

        if(!labymodPlayers.contains(player)) {
            labymodPlayers.add(player);
            player.sendMessage("§aThank you for playing with LabyMod!");
        }

    }

    @EventHandler
    public void on(PlayerQuitEvent event) {
        final Player player = event.getPlayer();  
        if(labymodPlayers.contains(player)) {
            labymodPlayers.remove(player);
        }
    }