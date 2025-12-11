## Plan: javafxMvcDocumentation for CHT Travel & Tours

This plan outlines a complete documentation set for the JavaFX CHT Travel and Tours Management System: what documents
should exist, their structure, audiences, and key points. It’s tailored to this project’s JavaFX + MVC/MVVM architecture
and package layout, so another agent (or you) can later fill in the actual content.

---

### 1. Top-Level Overview Documentation

#### 1.1 `README.md` (Project Landing Page)

**Audience:** New developers, evaluators, instructors, technical stakeholders, advanced users.

**Purpose:** High-level introduction, quick start, and navigation to deeper docs.

**Sections & Key Points:**

1. **Project Summary**
    - One-paragraph description of CHT Travel & Tours Management System.
    - Main features: booking management, customer/employee handling, authentication, etc.
    - Technology stack: Java, JavaFX, Maven, FXML, MVC/MVVM, logging via `logback.xml`.
    - Link to architecture overview doc.

2. **Screenshots / UI Overview**
    - Mention key screens: Login, Main Layout, Employee management, Booking steps (`AddBooking1–5-view.fxml`).
    - Reference where screenshots are stored (e.g., `docs/screenshots/`).

3. **Key Features**
    - Booking flow: multi-step FXML views for booking creation.
    - Customer and employee management.
    - Authentication and registration (`Login-view.fxml`, `Register-view.fxml`).
    - Role-based access (if applicable).
    - Any reporting or search capabilities if present.

4. **Tech Stack & Project Structure**
    - List major frameworks/tools: JavaFX, Maven, Java modules (`module-info.java`), logging.
    - High-level explanation of package structure:
        - `client`: application bootstrapping (`ClientApp`).
        - `controller`: JavaFX controllers.
        - `viewmodel`: MVVM ViewModels (where applicable).
        - `service` & `repository`: business logic and data access.
        - `model`: domain entities (`Booking`, `Customer`, `Employee`, etc.).
        - `navigation`: scene and FXML navigation.
        - `config`: `DatabaseConfig`, `ConfigLoader`.
        - `exception`, `utils`.
    - Link to detailed architecture doc.

5. **Quick Start / Running the Application**
    - Prerequisites: Java version, Maven version, JavaFX runtime requirements.
    - Setup steps for Linux/macOS/Windows:
        - Clone repo.
        - Configure environment variables or `application.properties` (database connection, etc.).
        - Maven commands to build and run.
    - How to run from IDE (IntelliJ IDEA) with JavaFX module settings.
    - Known issues (e.g., JavaFX module path gotchas).

6. **Configuration Overview**
    - Mention `application.properties` and what is configurable (DB URL, credentials, logging level, etc.).
    - Link to detailed config doc.

7. **Testing & Quality**
    - Note presence/type of tests (unit/integration) if they exist.
    - Example Maven command to run tests.
    - Link to more detailed testing strategy in developer guide.

8. **Project Status & Roadmap (Optional)**
    - Current status (prototype, beta, production-ready).
    - Short bullet roadmap for major next features.

9. **Contributing & Development**
    - Short paragraph with link to `CONTRIBUTING.md`.
    - Mention code style, pull request expectations.

10. **License & Credits**
    - License type (if defined).
    - Acknowledgments (team members, academic project details, etc.).

---

### 2. Architecture & Design Documentation

#### 2.1 `docs/architecture-overview.md`

**Audience:** Developers, architects, maintainers.

**Purpose:** Explain how the system is structured, how layers interact, and how JavaFX + MVC/MVVM are applied.

**Sections & Key Points:**

1. **Goals & Non-Goals**
    - Architectural goals: separation of concerns, testability, clear navigation, modular design.
    - Non-goals: e.g., not yet distributed, not microservices, no clustering, etc.

2. **High-Level System Diagram**
    - A block diagram description: UI (FXML + Controllers/ViewModels) → Service Layer → Repository Layer → Database.
    - Show `client.ClientApp` as the entry point bootstrapping JavaFX and wiring navigation/config.

3. **Module & Package Structure**
    - Explain `module-info.java`:
        - What the main module exports and requires (e.g., `javafx.controls`, `javafx.fxml`, JDBC).
    - Package-by-component:
        - `client`: `ClientApp` launching logic; how it initializes the primary stage and loads the first FXML.
        - `controller`: role of controllers in handling user interactions and binding to viewmodels.
        - `viewmodel`: MVVM responsibilities (state, validation, commands).
        - `service`: business logic and transaction boundaries.
        - `repository`: direct database or persistence interactions.
        - `model`: plain domain objects / entities.
        - `navigation`: central navigation (e.g., `SceneController`, `ControllerFactory`, `FXMLPaths`).
        - `config`: config loading and DB configuration.
        - `exception`: domain and infrastructure exceptions (`DataAccessException`, `ValidationException`).
        - `utils`: helper classes (describe typical responsibilities).
    - Provide a short description for each, with example classes to reference.

4. **MVC / MVVM Application in JavaFX**
    - How MVC is mapped:
        - View: FXML files under `view/` (e.g., `Login-view.fxml`).
        - Controller: classes in `controller` associated via `fx:controller`.
        - Model: domain classes under `model`.
    - Where MVVM is used:
        - `viewmodel` carries observable state, validation, and commands.
        - Controller’s role as a bridge between FXML controls and ViewModel.
    - Data binding examples: one-way, two-way binding between controls and viewmodel properties.

5. **Scene & Navigation Management**
    - Responsibilities of `SceneController` and `ControllerFactory`.
    - Role of `FXMLPaths` (and any inner enums like `BookingStatus`).
    - How screens are switched (e.g., login → main layout → booking wizard).
    - How back/forward or multi-step booking navigation is handled using `AddBooking1-view.fxml` …
      `AddBooking5-view.fxml`.

6. **Domain Model Overview**
    - Brief description of main domain classes:
        - `Booking`: key fields (customer, date, destination, status, etc.).
        - `Customer`: identity and contact details.
        - `Employee`: roles and permissions.
    - Relationships: Booking to Customer, Booking to Employee, etc.
    - Mention any enums or value objects if present.

7. **Data Access & Persistence**
    - Role of repository interfaces/implementations in `repository` package.
    - How database configuration is handled via `DatabaseConfig` and `application.properties`.
    - Error handling strategy for data access using `DataAccessException`.
    - Transaction and connection management approach (if explicit).

8. **Business Logic & Services**
    - Responsibilities of services (e.g., `BookingService`, `CustomerService`, `EmployeeService`).
    - How controllers/viewmodels call services.
    - Validation responsibilities: where `ValidationException` is thrown, what layer enforces business rules.

9. **Configuration & Environment**
    - How `ConfigLoader` works and where it’s used.
    - Configuration sources: `application.properties`, system properties, environment variables.
    - Environments: dev/test/prod strategies (if any).

10. **Cross-Cutting Concerns**
    - **Logging:**
        - How logging is configured (via `logback.xml`).
        - Logging levels and categories.
        - Logging best practices for controllers/services/repositories.
    - **Error Handling:**
        - UI-facing error handling: how exceptions get surfaced to end users.
        - Internal exception hierarchy (`DataAccessException`, `ValidationException`, and others).

11. **Extensibility & Modification Points**
    - How to add a new feature or module:
        - Adding new FXML + controller + viewmodel.
        - Extending services and repositories.
    - Where to hook new navigation targets.
    - Extension points in configuration and utilities.

---

#### 2.2 `docs/architecture-decisions.md` (ADR Summary)

**Audience:** Architects, senior developers, reviewers.

**Purpose:** Capture the “why” behind key technical decisions.

**Sections & Key Points:**

1. **Introduction**
    - Purpose of ADRs and how to read this document.
    - Link to individual ADR files if used (e.g., `docs/adr/NNN-title.md`).

2. **Key Decisions (Short Form)**
    - Use of JavaFX over other UI frameworks.
    - Choice of MVC+MVVM hybrid instead of pure MVC.
    - Decision to use FXML views with controllers rather than in-code layouts.
    - Use of Maven and modular Java (`module-info.java`).
    - Database access approach (e.g., plain JDBC, ORM, or custom abstractions).
    - Logging framework choice (`logback`).

3. **Future/Planned Decisions**
    - Items under consideration (e.g., REST API addition, migration to different DB).
    - High-level pros/cons.

---

### 3. User-Facing Documentation

#### 3.1 `docs/user-guide.md`

**Audience:** End users (travel agency staff, administrators), QA, instructors evaluating features.

**Purpose:** Explain how to install, run, and use the application’s features.

**Sections & Key Points:**

1. **Introduction**
    - Who this guide is for.
    - Short overview of capabilities.

2. **Installation & Launching**
    - Downloading/building the application.
    - System requirements (OS, RAM, JDK version).
    - How to start the application from:
        - Command line (Maven / packaged JAR).
        - IDE (if relevant for demo).

3. **Logging In & Registration**
    - How to register a new account via `Register-view.fxml` UI.
    - Login steps via `Login-view.fxml`.
    - Common login issues and what to do (incorrect credentials, locked account, etc.).

4. **Main Layout & Navigation**
    - Overview of `MainLayout-view.fxml` / `MainLayout-view2.fxml`:
        - Main menu, sidebar, top bar, etc.
        - Explanation of navigation to modules (Bookings, Customers, Employees, etc.).
    - Explanation of icons/buttons used across the app.

5. **Managing Bookings**
    - Step-by-step walk-through of the multi-step booking flow:
        - Screen 1 to 5 (`AddBooking1–5-view.fxml`).
        - What each step collects (customer info, travel details, payment, confirmation).
    - How to edit or cancel bookings (if supported).
    - Searching and filtering bookings (if supported).

6. **Managing Customers**
    - Adding a new customer.
    - Viewing and updating customer details.
    - Customer search and filtering.

7. **Managing Employees**
    - Navigating to `Employee-view.fxml`.
    - Adding/updating employee records.
    - Assigning roles/permissions (if implemented).

8. **Other Features**
    - Reporting, export, or printing (if present).
    - Settings/config screens (if any).

9. **Error Messages & Troubleshooting**
    - Common UI error messages and what they mean.
    - What to do if a validation error occurs (e.g., missing required fields).
    - What to do if a database or network error appears.

10. **FAQ**
    - Short list of common questions about usage and behavior.

---

#### 3.2 `docs/user-faq.md` (Optional, if content grows)

**Audience:** End users, support staff.

**Purpose:** Central place for recurring questions not covered in detail in user guide.

**Sections & Key Points:**

1. **General Usage Questions**
2. **Login & Account Questions**
3. **Booking Questions**
4. **Data & Privacy Questions** (if relevant).

---

### 4. Developer & Contributor Documentation

#### 4.1 `docs/developer-guide.md`

**Audience:** New and existing developers, advanced contributors.

**Purpose:** Step-by-step guide to set up the dev environment, understand workflows, and work effectively on the
codebase.

**Sections & Key Points:**

1. **Overview**
    - Who this guide is for.
    - Link back to `README.md` and architecture overview.

2. **Development Environment Setup**
    - Required tools: JDK version, Maven, Git, IDE (IntelliJ IDEA recommended).
    - JavaFX setup considerations (module path, VM options).
    - Recommended IDE run configuration for `ClientApp`.

3. **Project Layout Walkthrough**
    - Detailed explanation of:
        - `src/main/java/com/cht/TravelAndToursManagement/...`
        - `src/main/resources/...`
    - Mapping between view FXML files and controllers/viewmodels.
    - How navigation uses `FXMLPaths` to locate FXML resources.

4. **Build & Run from Source**
    - Maven commands to:
        - Compile.
        - Run tests.
        - Package a runnable artifact.
    - How to run the application with `mvn javafx:run` or custom plugin, if used.

5. **Configuration for Developers**
    - Editing `application.properties` for local DB.
    - Using alternate configs for test vs dev (if supported).
    - Where to store local overrides (e.g., `application-dev.properties` or environment variables).

6. **Debugging & Logging**
    - How to enable more verbose logging via `logback.xml`.
    - Using IDE breakpoints in controllers, viewmodels, services, repositories.
    - Troubleshooting common dev-time issues (e.g., FXML load failures).

7. **Working with MVC/MVVM**
    - Pattern for adding a new screen:
        - Create FXML under `view`.
        - Create controller under `controller`.
        - Optionally create a corresponding ViewModel under `viewmodel`.
    - How to bind JavaFX controls to ViewModel properties.
    - Input validation pattern (where to put validation logic, how to surface errors in the UI).

8. **Services & Repositories**
    - Design guidelines for service classes (thin vs thick services).
    - How to add a new repository for a domain entity.
    - Patterns for exception handling and propagating errors to upper layers.

9. **Testing**
    - How to write and run unit tests for:
        - Services (mocking repositories).
        - Repositories (using test DB or in-memory DB).
    - (If applicable) UI tests (TestFX or similar).
    - Location and naming conventions for test classes.

10. **Code Style & Conventions**
    - Naming conventions for controllers (`SomethingController`), viewmodels (`SomethingViewModel`), and FXML (
      `Something-view.fxml`).
    - Package naming and structure rules.
    - Formatting rules (if code style config is present).

11. **Performance & Optimization Considerations**
    - Any known performance constraints (e.g., large booking lists).
    - Guidelines for not blocking the JavaFX Application Thread (using background tasks, etc.).

---

#### 4.2 `CONTRIBUTING.md`

**Audience:** External contributors, classmates, collaborators.

**Purpose:** Define how to propose changes and standards to follow.

**Sections & Key Points:**

1. **Introduction & Scope**
    - Who can contribute.
    - High-level process: fork → branch → PR.

2. **Getting Started**
    - Link to `developer-guide.md` for environment setup.
    - Quick-start checklist.

3. **Branching & Workflow**
    - Naming conventions for branches (e.g., `feature/...`, `bugfix/...`).
    - Use of pull requests and code reviews.

4. **Coding Standards**
    - Java style guidelines; link to any style guide in repo.
    - Expectations for comments, Javadoc, and documentation updates with code changes.

5. **Commit Message Conventions**
    - Preferred format (e.g., short summary, present tense).
    - Reference to issues or tasks in commit messages.

6. **Testing Expectations**
    - Requirement to run tests before submitting PR.
    - When to add new tests.
    - How to include manual verification notes for UI changes.

7. **Issue Reporting & Feature Requests**
    - How to open an issue (if GitHub or similar).
    - What information to include: steps to reproduce, logs, screenshots.

8. **Code of Conduct (Optional/Recommended)**
    - Link to or short summary of behavior expectations.

---

#### 4.3 `docs/api-overview.md` (Internal API & Key Classes)

**Audience:** Developers needing a quick tour of important internal APIs.

**Purpose:** Summarize key classes, interfaces, and how to use them.

**Sections & Key Points:**

1. **Entry Points**
    - `client.ClientApp`: how it’s structured and initialized.

2. **Navigation API**
    - `SceneController`: core operations (load/show scenes).
    - `ControllerFactory`: how controllers are created and dependencies are resolved.
    - `FXMLPaths` and how to select FXML for a scene.

3. **Service Layer**
    - List primary service classes and their key methods.
    - Guidelines for synchronous vs asynchronous calls (if any).

4. **Repository Layer**
    - Interface examples and typical CRUD method patterns.
    - Error-handling pattern using `DataAccessException`.

5. **ViewModel & Controller Contracts**
    - Typical properties, commands, and lifecycle hooks (e.g., `initialize` in controller).

6. **Utilities & Helpers**
    - Notable utilities (e.g., date formatting, validation helpers).
    - How/when to use them.

---

### 5. Operations, Config, and Maintenance Docs

#### 5.1 `docs/configuration.md`

**Audience:** DevOps, maintainers, advanced users, developers.

**Purpose:** Central reference for all configuration options and environments.

**Sections & Key Points:**

1. **Configuration Overview**
    - Where configs live: `application.properties`, environment variables, logback config.
    - How configuration is loaded (`ConfigLoader` usage).

2. **Application Properties Reference**
    - For each key in `application.properties`:
        - Description.
        - Default value.
        - Example values.
        - Impact and related components (e.g., DB connection URL → `DatabaseConfig`).

3. **Database Configuration**
    - Required properties for database connectivity (URL, username, password, driver).
    - Recommended values for development vs production.
    - Connection pool settings (if used).

4. **Logging Configuration**
    - `logback.xml` structure and main appenders.
    - How to change log level globally or per package.
    - Location and rotation strategy of `logs/app.log`.

5. **Environment-Specific Configurations**
    - How to set up:
        - Local dev environment.
        - Test/staging environment.
        - Production environment (if applicable).
    - How to override properties without modifying version-controlled files (e.g., environment variables, separate
      config files).

---

#### 5.2 `docs/operations-guide.md` (Optional if project is deployed)

**Audience:** Operators, support engineers, maintainers.

**Purpose:** Explain how to deploy, monitor, and maintain the app in runtime environments.

**Sections & Key Points:**

1. **Deployment Scenarios**
    - Running as a standalone desktop app.
    - Running on specific OS distributions or RDP environments.

2. **Startup & Shutdown Procedures**
    - Commands or scripts to start/stop.
    - Checking logs for problems.

3. **Monitoring & Logs**
    - Where logs are stored and how to rotate/cleanup.
    - Typical log messages to watch for.

4. **Backup & Recovery**
    - Database backup/restore considerations (if relevant).

5. **Upgrades**
    - Steps to upgrade to a new version of the application.

---

### 6. Testing & Quality Documentation

#### 6.1 `docs/testing-strategy.md`

**Audience:** Developers, QA, maintainers.

**Purpose:** Describe testing approach and how to maintain test quality.

**Sections & Key Points:**

1. **Testing Overview**
    - Types of tests used (unit, integration, UI).
    - What’s covered vs not covered.

2. **Unit Testing**
    - Where unit tests live (e.g., under `src/test/java/...`).
    - Tools/frameworks used (JUnit, Mockito, etc., if present).
    - Patterns for testing services and repositories.

3. **Integration Testing**
    - When integration tests are used (e.g., DB access).
    - Database fixtures or in-memory DB usage.

4. **UI Testing (If Applicable)**
    - Framework for UI tests (e.g., TestFX).
    - Basic guidelines on writing stable UI tests.

5. **Manual Testing Checklist**
    - Key flows to verify manually:
        - Login, registration.
        - Booking creation flow.
        - Employee management.
    - Regression checks for major releases.

6. **Continuous Integration (If Configured)**
    - Summary of CI pipeline (e.g., GitHub Actions) if present.
    - Required checks before merging PRs.

---

### 7. Security & Data Documentation (Optional/Context-Dependent)

#### 7.1 `docs/security-considerations.md`

**Audience:** Developers, operators, reviewers.

**Purpose:** Document known security considerations and practices.

**Sections & Key Points:**

1. **Authentication & Authorization**
    - How login is implemented.
    - Where user data and roles are stored.
    - Any password hashing or encryption details.

2. **Data Protection**
    - Handling of sensitive information (customer data).
    - Guidelines for developers to avoid logging PII.

3. **Input Validation & Error Handling**
    - Validation policies at UI and service layers.
    - Where `ValidationException` fits in.

4. **Known Limitations & Future Work**
    - Security gaps to be addressed.
    - Planned mitigations or enhancements.

---

### 8. Meta & Documentation Maintenance

#### 8.1 `docs/documentation-index.md` (or `docs/README.md`)

**Audience:** Anyone browsing docs.

**Purpose:** Central index linking all documentation pieces.

**Sections & Key Points:**

1. **Document Map**
    - List each document with a one-line description:
        - `README.md`
        - `docs/architecture-overview.md`
        - `docs/developer-guide.md`
        - `docs/user-guide.md`
        - `CONTRIBUTING.md`, etc.

2. **Lifecycle & Ownership**
    - Who is responsible for keeping each doc up-to-date (roles, not names).
    - Suggest updating docs in the same PR as code changes.

3. **Conventions**
    - Preferred format (Markdown).
    - Where to store diagrams or images.

---

### Steps

1. Identify target locations for each document (e.g., `docs/` folder, root files like `README.md`, `CONTRIBUTING.md`)
   and align with any existing documentation.
2. For each document above, create an outline reflecting the sections and key points, adjusting based on current project
   features and maturity.
3. Cross-check the planned sections against the existing codebase (packages, classes, FXML views, configs) to ensure all
   important features and architectural elements are covered.
4. Prioritize which documents to write first (likely `README.md`, `architecture-overview.md`, `developer-guide.md`,
   `user-guide.md`, `CONTRIBUTING.md`) and define a realistic documentation roadmap.
5. Set up a process to keep documentation in sync with changes (e.g., PR template checklist to update relevant docs when
   modifying features or architecture).

---

### Further Considerations

1. Decide how formal you want architecture decisions: single summary file vs full ADR series for each change.
2. Clarify the depth needed for user docs: internal training-level detail vs high-level demo narrative.
3. Consider adding minimal auto-generated JavaDoc or API doc hosting if the codebase grows significantly.

