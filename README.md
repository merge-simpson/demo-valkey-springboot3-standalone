[English](#download-project) | **🇰🇷 Korean**

# 프로젝트 받기

깃이 설치되어 있어야 합니다. ([Git 설치](https://git-scm.com/download/win))  
원하는 경로에서 다음 명령어를 입력하면, 프로젝트가 하위 폴더로 다운로드됩니다.  
터미널에서 경로 이동은 `cd` 명령어를 이용하세요.
([Change Directory](https://www.google.com/search?q=change+directory))

```bash
git clone https://github.com/merge-simpson/demo-valkey-springboot3-standalone.git
```

이 프로젝트를 IDE에서 열고, gradle 프로젝트로 인식시켜 주면 필요한 의존성 라이브러리 목록이 설치됩니다.

# Valkey 설치 (Local)

1. **Prerequisite**
   - docker compose 설치가 되어있어야 합니다.
     ([docker desktop 설치](https://www.docker.com/products/docker-desktop/))
   - docker가 실행되고 있어야 합니다.

2. **Command Lines**

   프로젝트 루트경로에서 다음 명령어를 실행합니다.

    ```bash
    docker compose up -d
    ```
    <details>
      <summary> 컨테이너 내리기(데이터는 보존) </summary> 
      <div markdown="1"> 

      ```bash
      docker compose down 
      ```

      </div>
    </details>

    <details> 
      <summary> 컨테이너 내리기(데이터도 삭제) </summary> 
      <div markdown="1">

      ```bash
      docker compose down -v 
      ```

      </div>
    </details>

# Valkey는 redis를 대신합니다.

스프링부트3에서 redis를 다루기 위한 주요 라이브러리를 valkey에 그대로 적용할수 있습니다.

이 프로젝트는 그것이 가능한지 검토한 프로젝트입니다.

---

**English** | 🇰🇷 [Korean](#프로젝트-받기)

# Download Project

Make sure you have Git installed: [Install Git](https://git-scm.com/download/win)  
Enter the below command in the desired directory, and the project will be downloaded as a subfolder.  
Use the `cd` command to move the directory in your terminal.
([Change Directory](https://www.google.com/search?q=change+directory))

```bash
git clone https://github.com/merge-simpson/demo-valkey-springboot3-standalone.git
```

Open project and recognize it as a gradle project in your IDE, and the dependency libraries will be installed.

# Install Valkey (Local)

1. **Prerequisite**
    - You must have docker compose installed.
      ([Install docker desktop](https://www.docker.com/products/docker-desktop/))
    - Docker must be running.

2. **Command Lines**

   Run the following command in the root directory of the project.  

    ```bash
    docker compose up -d
    ```
    <details>
      <summary> Drop containers (data is preserved) </summary> 
      <div markdown=“1”> 

      ```bash
      docker compose down 
      ```

      </div>
    </details>

    <details> 
      <summary> Drop containers (and deleting data) </summary> 
      <div markdown=“1”>

      ```bash
      docker compose down -v 
      ```

      </div>
    </details>

# Valkey Is Alternative to Redis.

The major libraries for dealing with redis in springboot3 can be applied to valkey as is.

This project is an examination of whether that is possible.