# meta-polygondata-rauc

---

## Deutsch 🇩🇪

Yocto/OpenEmbedded Layer zur Integration von **RAUC OTA Updates** in eine
Embedded-Linux-Distribution auf Basis von **OpenRC** und **ohne DBus**.

Der Layer stellt eine saubere und reproduzierbare RAUC-Integration bereit,
inklusive eigener Health-Checks und Agent-Komponenten, und ist für den Einsatz
in CI-Umgebungen sowie produktiven Systemen ausgelegt.

### Features

- RAUC-Integration für Yocto / OpenEmbedded
- Unterstützung für OpenRC (kein systemd, kein DBus)
- Eigene RAUC-Konfiguration (`system.conf`)
- Separate Pakete:
  - `rauc`
  - `rauc-agent`
  - `rauc-health`
- OTA-fähige Image-Erweiterung über bbclass
- SSH-basierter Git-Fetch (CI- und Enterprise-tauglich)
- Fokus auf reproduzierbare Builds und saubere Paketierung

### Aktivierung

```bitbake
inherit polygondata-rauc-image
DISTRO_FEATURES:append = " rauc"
```

### Git (SSH)

```bash
export GIT_SSH_COMMAND="ssh -o BatchMode=yes -o StrictHostKeyChecking=yes"
```

---

## English 🇬🇧

Yocto/OpenEmbedded layer for integrating **RAUC OTA updates** into an
Embedded Linux distribution based on **OpenRC** and **without DBus**.

This layer provides a clean and reproducible RAUC integration, including
custom health checks and agent components. It is designed for CI environments
and production systems.

### Features

- RAUC integration for Yocto / OpenEmbedded
- OpenRC support (no systemd, no DBus)
- Custom RAUC configuration (`system.conf`)
- Separate packages:
  - `rauc`
  - `rauc-agent`
  - `rauc-health`
- OTA-capable image extension via bbclass
- SSH-based Git fetch (CI- and enterprise-ready)
- Focus on reproducible builds and clean packaging

### Enabling

```bitbake
inherit polygondata-rauc-image
DISTRO_FEATURES:append = " rauc"
```

### Git (SSH)

```bash
export GIT_SSH_COMMAND="ssh -o BatchMode=yes -o StrictHostKeyChecking=yes"
```

---

## License

MIT
