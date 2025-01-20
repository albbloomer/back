# Docker Network Practice

이 프로젝트는 Docker 네트워크 환경을 실습하기 위해 다양한 네트워크 설정을 포함합니다. 각 설정은 Redis 컨테이너를 사용하며, `docker-compose` 파일로 정의되어 있습니다.

---

## 1. 프로젝트 디렉토리 구조

```
networkpractice/
├── docker-compose-bridge.yml       # 브리지 네트워크 환경
├── docker-compose-dns.yml          # 사용자 정의 네트워크 + DNS
├── docker-compose-host.yml         # 호스트 네트워크 환경
├── docker-compose-isolated.yml     # 고립된 네트워크 환경
├── docker-compose-multi-net.yml    # 멀티 네트워크 환경
└── readme.md                       # 설명 문서
```

---

## 2. 각 환경의 설정 및 명령어

### 2.1 Bridge Network (docker-compose-bridge.yml)
Redis 컨테이너를 Docker 기본 브리지 네트워크에 연결합니다.

- **실행 명령어:**
  ```bash
  docker-compose -f docker-compose-bridge.yml up -d
  ```
- **중지 명령어:**
  ```bash
  docker-compose -f docker-compose-bridge.yml down
  ```

---

### 2.2 Host Network (docker-compose-host.yml)
Redis 컨테이너를 호스트 네트워크에 연결하여, `localhost`와 동일한 네트워크 환경을 제공합니다.

- **실행 명령어:**
  ```bash
  docker-compose -f docker-compose-host.yml up -d
  ```
- **중지 명령어:**
  ```bash
  docker-compose -f docker-compose-host.yml down
  ```

---

### 2.3 Isolated Network (docker-compose-isolated.yml)
독립적인 네트워크 환경에서 Redis 컨테이너를 실행합니다.

- **실행 명령어:**
  ```bash
  docker-compose -f docker-compose-isolated.yml up -d
  ```
- **중지 명령어:**
  ```bash
  docker-compose -f docker-compose-isolated.yml down
  ```

---

### 2.4 Multi Network (docker-compose-multi-net.yml)
컨테이너를 여러 네트워크에 연결하여 네트워크 간 통신을 실습합니다.

- **실행 명령어:**
  ```bash
  docker-compose -f docker-compose-multi-net.yml up -d
  ```
- **중지 명령어:**
  ```bash
  docker-compose -f docker-compose-multi-net.yml down
  ```

---

### 2.5 Custom DNS Network (docker-compose-dns.yml)
사용자 정의 네트워크 및 DNS를 설정하여 Redis 컨테이너를 실행합니다.

- **실행 명령어:**
  ```bash
  docker-compose -f docker-compose-dns.yml up -d
  ```
- **중지 명령어:**
  ```bash
  docker-compose -f docker-compose-dns.yml down
  ```

---

## 3. 네트워크 상태 확인 명령어

Docker 네트워크 상태를 확인하려면 아래 명령어를 사용하세요:

- **네트워크 목록 확인:**
  ```bash
  docker network ls
  ```

- **특정 네트워크 상세 정보 확인:**
  ```bash
  docker network inspect [네트워크 이름]
  ```

- **컨테이너 네트워크 상태 확인:**
  ```bash
  docker ps
  ```

---

## 4. 기타 명령어

- **모든 네트워크 삭제 (주의: 기본 네트워크 제외):**
  ```bash
  docker network prune
  ```

- **모든 컨테이너 중지 및 삭제:**
  ```bash
  docker stop $(docker ps -q) && docker rm $(docker ps -aq)
  ```

---
