# meta-polygondata-rauc

Yocto/OpenEmbedded Layer zur Integration von **RAUC OTA Updates** in eine
Embedded-Linux-Distribution auf Basis von **OpenRC**.

Der Layer stellt eine saubere, reproduzierbare RAUC-Integration bereit,
inklusive eigener Health-Checks und Agent-Komponenten, und ist für den Einsatz
in CI-Umgebungen und produktiven Systemen ausgelegt.

---

## Features

- RAUC Integration für Yocto / OpenEmbedded
- Unterstützung für OpenRC (kein systemd)
- Eigene RAUC-Konfiguration (`system.conf`)
- Separate Pakete für:
  - `rauc`
  - `rauc-agent`
  - `rauc-health`
- OTA-fähige Image-Erweiterung per bbclass
- SSH-basierter Git-Fetch (CI- und Enterprise-tauglich)
- Fokus auf:
  - reproduzierbare Builds
  - saubere Paketierung
  - minimale Eingriffe in bestehende Images

---

## Layer-Struktur
```
meta-polygondata-rauc/
├── conf/
│ └── layer.conf
├── classes/
│ └── polygondata-rauc-image.bbclass
└── recipes-rauc/
│ └── rauc/
├── rauc_%.bbappend
├── rauc-agent.bb
├── rauc-health.bb
└── files/
 └── system.conf
```
---

## Voraussetzungen

- Yocto / OpenEmbedded (poky)
- meta-rauc Layer
- OpenRC (z. B. via meta-openrc)
- SSH-Zugriff auf die verwendeten Git-Repositories

---

## Einbindung des Layers

Layer zum Build hinzufügen:

```bash
bitbake-layers add-layer meta-polygondata-rauc
```
Aktivierung im Image
Der Layer bringt eine bbclass mit, um RAUC-Komponenten sauber in Images zu integrieren.
Im Image-Recipe oder in einer Image-bbclass:

inherit polygondata-rauc-image
Die benötigten Pakete werden appendet, nicht überschrieben:
- rauc
- rauc-agent
- rauc-health
DISTRO_FEATURES
Für eine saubere RAUC-Integration wird empfohlen, RAUC explizit als
Distro-Feature zu aktivieren:
- DISTRO_FEATURES:append = " rauc"
RAUC-Konfiguration
Die Datei system.conf wird bewusst über diesen Layer bereitgestellt
und nicht aus einem separaten Konfigurationspaket, um:
Paketkonflikte im RootFS zu vermeiden
die RAUC-Konfiguration versionskontrolliert zu halten
Pfad im Zielsystem:
/etc/rauc/system.conf
Git-Fetch via SSH
Dieser Layer verwendet bewusst SSH für Git-Fetches:
keine Passwörter oder Tokens in Recipes
geeignet für CI (Deploy-Keys)
non-interaktive Builds
Empfohlene Umgebung:
export GIT_SSH_COMMAND="ssh -o BatchMode=yes -o StrictHostKeyChecking=yes"
Reproduzierbarkeit
SRCREV ist fixiert
keine Überschreibung von IMAGE_INSTALL
keine leeren RDEPENDS
bekannte Yocto-Fallen (RootFS-Clashes, Paket-Overwrites) wurden vermieden
Status
✔ Build erfolgreich
✔ RootFS konfliktfrei
✔ CI-tauglich
✔ Produktiv einsetzbar
Zielgruppe
Dieser Layer richtet sich an:
Embedded-Linux-Entwickler
Yocto-/OpenEmbedded-Projekte
Systeme mit OTA-Update-Anforderungen
industrielle und professionelle Linux-Plattformen
Lizenz
Projekt- und Firmenabhängig.
Bitte entsprechend anpassen.

---

