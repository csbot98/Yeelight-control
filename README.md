# Yeelight Kotlin API:

### Az eredeti API: [link](https://github.com/omarmiatello/yeelight)

Az eredeti API lett átírva annak megfelelően, hogy Androidos környezetben is megfelelően fusson (függőségek, osztályok, stb.), plusz néhol kiegészítettem.
Pl.: 
- SendCmd: 3x próbálkozik elküldeni a command-ot az eszköznek.
- getAllYeelightDeviceIds: Külön kezelni lehet az ID-kat (ID alapján lehet command-ot küldeni az eszköznek), jelen esetben majd a későbbiek során ki lesznek listázva. Plusz változóban elmenti az első talált ID-t, így nem kell kézzel beleírni. Esetleg még ki lehet egészíteni majd egy olyannal, hogy akcióra, ugrojon a következőre.
- A main-ben (vagy a demo-ban ha úgy tetszik) egy TextView-ban kiírja az első talált eszköz ID-ját és van egy Button, amivel fel-le lehet kapcsolni az eszközt.      

## Röviden a mükődésről:
Egy hálozaton lévő Yeelight eszközöket lehet felderíteni és irányítani.
