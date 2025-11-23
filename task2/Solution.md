task2 — Объектно-ориентированное программирование (ч.2)
================================================================

2.1. Класс Spaceship (Корабль)
-------------------------------
**Поля:**
- `callsign` - позывной
- `hullType` - тип корпуса
- `massTons` - масса (тонны)
- `remainingFuel` - остаток топлива (%)
- `crewCapacity` - вместимость экипажа
- `topSpeed` - максимальная скорость (доля скорости света)

**Конструктор:**
- `Spaceship(String call, String hull, double mass, double fuel, int crew, double speed)` - создаёт корабль с параметрами

**Методы:**
- `refuel(double amount)` - заправить корабль (увеличивает топливо, максимум 100%)
- `consumeFuel(double amount)` - потратить топливо (уменьшает топливо, минимум 0%)
- `setSpeed(double speed)` - установить скорость
- `accelerate(double increment)` - ускориться (увеличивает скорость)
- `decelerate(double decrement)` - замедлиться (уменьшает скорость, минимум 0)
- `fly(double distance)` - лететь (тратит топливо, вызывает consumeFuel)
- `stop()` - остановиться (скорость = 0)

2.2. Класс Pilot (Пилот)
-------------------------
**Поля:**
- `name` - имя
- `experienceYears` - опыт (годы)
- `specialization` - специализация
- `certifiedForWarp` - варп-сертификация
- `completedMissions` - завершённые миссии
- `stressLevel` - уровень стресса (0..1)

**Конструктор:**
- `Pilot(String n, int exp, String spec, boolean warp)` - создаёт пилота с параметрами

**Методы:**
- `completeMission()` - завершить миссию (увеличивает миссии, опыт и стресс)
- `increaseStress(double amount)` - увеличить стресс (максимум 1.0)
- `rest(double amount)` - снизить стресс (минимум 0.0)
- `certifyForWarp()` - получить варп-сертификацию
- `gainExperience(int years)` - увеличить опыт
- `relax()` - отдохнуть (комбинирует rest(0.2))

2.3. Класс Mission (Миссия)
----------------------------
**Поля:**
- `codeName` - кодовое имя
- `targetSystem` - целевая система
- `durationDays` - длительность (дни)
- `status` - статус
- `budgetMillions` - бюджет (миллионы)
- `riskLevel` - уровень риска (1..10)

**Конструктор:**
- `Mission(String code, String target, int duration, double budget, int risk)` - создаёт миссию с параметрами

**Методы:**
- `start()` - начать миссию (статус = "исполнение")
- `complete()` - завершить миссию (статус = "завершена")
- `cancel()` - отменить миссию (статус = "отменена")
- `increaseBudget(double amount)` - увеличить бюджет
- `decreaseBudget(double amount)` - уменьшить бюджет (минимум 0)
- `increaseRisk(int level)` - увеличить риск (максимум 10)
- `decreaseRisk(int level)` - снизить риск (минимум 1)
- `extendDuration(int days)` - продлить миссию
- `setStatus(String newStatus)` - установить статус
