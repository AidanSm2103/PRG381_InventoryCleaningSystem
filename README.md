## Database Setup (Apache Derby)

This project uses Apache Derby, run as a local network server. Each team member needs to set this up independently on their own machine — the database itself is not shared via Git.

### 1. Install Derby
1. Download the binary distribution from https://db.apache.org/derby/derby_downloads.html
2. Extract it somewhere permanent, e.g. `C:\Derby` (avoid OneDrive/Google Drive/Dropbox — synced folders cause file-lock issues)

### 2. Start the Derby network server
Every time you want to run this project, start the server first:
1. Open a terminal
2. Navigate to Derby's `bin` folder, e.g.: cd C:\Derby\db-derby-10.17.1.0-bin\bin
3. Run:
4. Leave this terminal window open while working — closing it stops the server and the app will lose its DB connection

You should see a message ending in "started and ready to accept connections on port 1527."

### 3. Create the database (first time only)
1. In NetBeans: **Services → Databases → Drivers** → register a new driver pointing to Derby's `derbyclient.jar`
2. Right-click **Databases → New Connection...**, select the Derby driver
3. Connection details:
   - Host: `localhost`
   - Port: `1527`
   - Database: `cleaninginventorydb`
   - User: `admin`
   - Password: `admin`
4. For the **first connection only**, add `;create=true` to the end of the JDBC URL — this creates the database if it doesn't exist yet
5. Test Connection → Finish
6. Remove `;create=true` from the connection after this first successful run

### 4. Run the schema
1. Right-click your new connection → **Execute Command...**
2. Open `sql/schema.sql` from the project, paste its contents into the SQL editor
3. Run it — this creates the `users`, `materials`, `suppliers`, `cleaners`, and `issuances` tables
4. Verify: expand your connection → **Tables** — you should see all 5 listed

### 5. Project classpath
The Derby client jars (`derbyclient.jar`, `derbyshared.jar`, `derbytools.jar`) are already included in the project's `lib/` folder and referenced in `nbproject/project.properties` — no need to add them again after cloning.

### Notes
- DAO methods that aren't implemented yet return empty lists (`new ArrayList<>()`), not `null` — keep this convention so other panels/screens don't crash on unfinished modules.
- Default login credentials aren't seeded — register a new user via the Register button on first run.
