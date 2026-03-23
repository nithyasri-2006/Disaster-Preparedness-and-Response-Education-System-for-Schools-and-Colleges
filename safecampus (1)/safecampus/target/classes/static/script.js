// 🔐 CHECK LOGIN (Protect Dashboard)
if (localStorage.getItem("loggedIn") !== "true") {
    window.location.href = "/login.html";
}

// 🔊 ALERT CONTROL
let previousCount = 0;
let myChart = null;

// 🔓 LOGOUT
function logout() {
    localStorage.removeItem("loggedIn");
    window.location.href = "/login.html";
}

// 🚨 REPORT DISASTER
function reportDisaster() {

    const type = document.getElementById("type").value.trim();
    const location = document.getElementById("location").value.trim();
    const description = document.getElementById("description").value.trim();

    if (!type || !location || !description) {
        alert("⚠️ Please fill all fields");
        return;
    }

    fetch("/disaster/report", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            disasterType: type,
            location: location,
            description: description
        })
    })
    .then(res => res.json())
    .then(() => {
        alert("✅ Disaster Reported Successfully!");
        clearInputs();

        // 🔊 Play alert instantly
        const sound = document.getElementById("alertSound");
        if (sound) sound.play();

        loadAll();
    })
    .catch(() => alert("❌ Error reporting disaster"));
}

// 🧹 CLEAR INPUTS
function clearInputs() {
    document.getElementById("type").value = "";
    document.getElementById("location").value = "";
    document.getElementById("description").value = "";
}

// 📥 LOAD ALL DATA
function loadAll() {
    loadDisasters();
    loadCount();
    loadChart();
}

// 📋 LOAD TABLE
function loadDisasters() {

    fetch("/disaster/all")
    .then(res => res.json())
    .then(data => {

        const table = document.getElementById("table");
        const search = document.getElementById("search").value.toLowerCase();

        table.innerHTML = `
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Location</th>
            <th>Description</th>
            <th>Status</th>
            <th>Action</th>
        </tr>`;

        data.forEach(d => {

            if (!d.location.toLowerCase().includes(search)) return;

            table.innerHTML += `
            <tr>
                <td>${d.id}</td>
                <td>${d.disasterType}</td>
                <td>${d.location}</td>
                <td>${d.description}</td>
                <td>${d.status || "Pending"}</td>
                <td>
                    <button class="btn btn-success btn-sm" onclick="resolve(${d.id})">
                        Resolve
                    </button>
                </td>
            </tr>`;
        });

    })
    .catch(() => console.log("Error loading table"));
}

// ✅ RESOLVE DISASTER
function resolve(id) {

    fetch("/disaster/resolve/" + id, {
        method: "PUT"
    })
    .then(() => {
        alert("✔️ Disaster Resolved");
        loadAll();
    })
    .catch(() => alert("❌ Error resolving disaster"));
}

// 🔢 LOAD COUNT + ALERT
function loadCount() {

    fetch("/disaster/all")
    .then(res => res.json())
    .then(data => {

        const count = data.length;
        document.getElementById("disasterCount").innerText = count;

        if (count > previousCount) {

            document.getElementById("alertBanner").style.display = "block";

            const sound = document.getElementById("alertSound");
            if (sound) sound.play();

            alert("🚨 New Disaster Reported!");
        }

        previousCount = count;

    })
    .catch(() => console.log("Error loading count"));
}

// 📊 LOAD CHART
function loadChart() {

    fetch("/disaster/all")
    .then(res => res.json())
    .then(data => {

        let fire = 0, flood = 0, other = 0;

        data.forEach(d => {
            if (d.disasterType === "Fire") fire++;
            else if (d.disasterType === "Flood") flood++;
            else other++;
        });

        const ctx = document.getElementById("chart");

        // 🔥 Fix: destroy previous chart
        if (myChart) {
            myChart.destroy();
        }

        myChart = new Chart(ctx, {
            type: "bar",
            data: {
                labels: ["Fire", "Flood", "Other"],
                datasets: [{
                    label: "Disaster Count",
                    data: [fire, flood, other]
                }]
            }
        });

    })
    .catch(() => console.log("Error loading chart"));
}

// 🔍 SEARCH LIVE FILTER
document.addEventListener("DOMContentLoaded", () => {

    const searchInput = document.getElementById("search");

    if (searchInput) {
        searchInput.addEventListener("keyup", loadDisasters);
    }

});

// 🔄 AUTO REFRESH (10 sec)
setInterval(loadAll, 10000);

// 🚀 INITIAL LOAD (SAFE)
window.onload = function () {
    loadAll();
};