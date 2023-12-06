<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<style>
.selected-date {text-align: center;}
.calendar-popup {position: fixed;top: 50%;left: 50%;transform: translate(-50%, -50%);z-index: 9999;background-color: #fff;box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);padding: 20px;display: none;width: 380px;max-height: 440px;overflow: hidden;}
.calendar-container {position: relative;display: inline-block;}
.calendar-popup .month {text-align: center;font-weight: bold;margin-bottom: 10px;}
.calendar-popup .navigator {display: flex;justify-content: space-between;align-items: center;margin-bottom: 10px;}
.calendar-popup .navigator button {background-color: transparent;border: none;outline: none;cursor: pointer;font-weight: bold;}
.calendar-popup .navigator .next-btn::before {content: "\25B6";}
.calendar-popup .navigator .prev-btn::before {content: "\25C0";} 
.calendar-popup .days {display: grid;grid-template-columns: repeat(7, 1fr);gap: 5px;text-align: center;overflow-y: auto;}
.calendar-popup .day {padding: 10px;cursor: pointer;}
.calendar-popup .day:hover {background-color: #f2f2f2;}
.calendar-popup .day.selected {background-color: #ccc;}
.calendar-popup .hidden {display: none;}
.calendar-popup .empty-day {visibility: hidden;}
.calendar-popup .close-btn {position: absolute;top: 10px;right: 10px;cursor: pointer;width:40px;height:40px; text-align:center; font-size:25px;}
</style>
<script>
  var today = new Date();
  var year = today.getFullYear();
  var month = today.getMonth() + 1;

  function formatDate(year, month, day) {
    month = month.toString().padStart(2, "0");
    day = day.toString().padStart(2, "0");
    return year + "-" + month + "-" + day;
  }

  function displayCalendar(year, month) {
    var monthElement = document.createElement("div");
    monthElement.classList.add("month");
    monthElement.textContent = year + "년 " + month + "월";
    calendarPopup.appendChild(monthElement);

    var closeButton = document.createElement("div");
    closeButton.classList.add("close-btn");
    closeButton.textContent = "X";
    closeButton.addEventListener("click", function() {
      calendarPopup.style.display = "none";
    });
    calendarPopup.appendChild(closeButton);

    var navigatorElement = document.createElement("div");
    navigatorElement.classList.add("navigator");

    var prevButton = document.createElement("button");
    prevButton.classList.add("prev-btn");
    prevButton.addEventListener("click", function() {
      var previousMonth = month === 1 ? 12 : month - 1;
      var previousYear = month === 1 ? year - 1 : year;

      if (previousYear < today.getFullYear() || (previousYear === today.getFullYear() && previousMonth < today.getMonth() + 1)) {
        return; // 현재 달 이전으로 이동하지 않도록 종료
      }

      calendarPopup.innerHTML = ""; 
      displayCalendar(previousYear, previousMonth);
    });
    navigatorElement.appendChild(prevButton);

    var nextButton = document.createElement("button");
    nextButton.classList.add("next-btn");
    nextButton.addEventListener("click", function() {
      calendarPopup.innerHTML = ""; 
      displayCalendar(month === 12 ? year + 1 : year, month === 12 ? 1 : month + 1);
    });
    navigatorElement.appendChild(nextButton);

    calendarPopup.appendChild(navigatorElement);

    var daysElement = document.createElement("div");
    daysElement.classList.add("days");
    calendarPopup.appendChild(daysElement);

    var firstDay = new Date(year, month - 1, 1);
    var lastDay = new Date(year, month, 0);
    var firstDayOfWeek = firstDay.getDay();
    var totalDays = lastDay.getDate();

    var weekdays = ["일", "월", "화", "수", "목", "금", "토"];

    for (var i = 0; i < weekdays.length; i++) {
      var weekday = document.createElement("div");
      weekday.classList.add("day");
      weekday.textContent = weekdays[i];
      daysElement.appendChild(weekday);
    }

    for (var i = 0; i < firstDayOfWeek; i++) {
      var emptyDay = document.createElement("div");
      emptyDay.classList.add("day");
      emptyDay.classList.add("empty-day"); 
      daysElement.appendChild(emptyDay);
    }

    var dayOfWeek = firstDayOfWeek;
    for (var i = 1; i <= totalDays; i++) {
      var day = document.createElement("div");
      day.classList.add("day");
      day.textContent = i;

      if (
        i === today.getDate() &&
        month === today.getMonth() + 1 &&
        year === today.getFullYear()
      ) {
        day.classList.add("selected");
        selectedDate = formatDate(year, month, i);
      }

      day.addEventListener("click", function() {
        var selectedDay = document.querySelector(".day.selected");
        if (selectedDay) {
          selectedDay.classList.remove("selected");
        }
        this.classList.add("selected");
        selectedDate = formatDate(year, month, this.textContent);

        var selectedDateElement = document.getElementById("selectedDate");
        selectedDateElement.textContent =  selectedDate;

        calendarPopup.style.display = "none"; 
      });

      daysElement.appendChild(day);

      dayOfWeek++;
      if (dayOfWeek % 7 === 0) {
        dayOfWeek = 0;
      }
    }

    for (var i = dayOfWeek; i < 7; i++) {
      var emptyDay = document.createElement("div");
      emptyDay.classList.add("day");
      emptyDay.classList.add("empty-day"); 
      daysElement.appendChild(emptyDay);
    }

    calendarPopup.style.display = "block";
  }

  function showCalendar() {
    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth() + 1;

    function formatDate(year, month, day) {
      month = month.toString().padStart(2, "0");
      day = day.toString().padStart(2, "0");
      return year + "-" + month + "-" + day;
    }

    function displayCalendar(year, month) {
      var monthElement = document.createElement("div");
      monthElement.classList.add("month");
      monthElement.textContent = year + "년 " + month + "월";
      calendarPopup.appendChild(monthElement);

      var navigatorElement = document.createElement("div");
      navigatorElement.classList.add("navigator");

      var prevButton = document.createElement("button");
      prevButton.classList.add("prev-btn");
      prevButton.addEventListener("click", function() {
        calendarPopup.innerHTML = ""; 
        displayCalendar(month === 1 ? year - 1 : year, month === 1 ? 12 : month - 1);
      });
      navigatorElement.appendChild(prevButton);

      var nextButton = document.createElement("button");
      nextButton.classList.add("next-btn");
      nextButton.addEventListener("click", function() {
        calendarPopup.innerHTML = ""; 
        displayCalendar(month === 12 ? year + 1 : year, month === 12 ? 1 : month + 1);
      });
      navigatorElement.appendChild(nextButton);

      calendarPopup.appendChild(navigatorElement);

      var daysElement = document.createElement("div");
      daysElement.classList.add("days");
      calendarPopup.appendChild(daysElement);

      var firstDay = new Date(year, month - 1, 1);
      var lastDay = new Date(year, month, 0);
      var firstDayOfWeek = firstDay.getDay();
      var totalDays = lastDay.getDate();

      var weekdays = ["일", "월", "화", "수", "목", "금", "토"];

      for (var i = 0; i < weekdays.length; i++) {
        var weekday = document.createElement("div");
        weekday.classList.add("day");
        weekday.textContent = weekdays[i];
        daysElement.appendChild(weekday);
      }

      for (var i = 0; i < firstDayOfWeek; i++) {
        var emptyDay = document.createElement("div");
        emptyDay.classList.add("day");
        emptyDay.classList.add("empty-day"); 
        daysElement.appendChild(emptyDay);
      }

      var dayOfWeek = firstDayOfWeek;
      for (var i = 1; i <= totalDays; i++) {
        var day = document.createElement("div");
        day.classList.add("day");
        day.textContent = i;

        if (
          i === today.getDate() &&
          month === today.getMonth() + 1 &&
          year === today.getFullYear()
        ) {
          day.classList.add("selected");
          selectedDate = formatDate(year, month, i);
        }

        day.addEventListener("click", function() {
          var selectedDay = document.querySelector(".day.selected");
          if (selectedDay) {
            selectedDay.classList.remove("selected");
          }
          this.classList.add("selected");
          selectedDate = formatDate(year, month, this.textContent);

          var selectedDateElement = document.getElementById("selectedDate");
          selectedDateElement.textContent =  selectedDate;

          calendarPopup.style.display = "none"; 
        });

        daysElement.appendChild(day);

        dayOfWeek++;
        if (dayOfWeek % 7 === 0) {
          dayOfWeek = 0;
        }
      }

      for (var i = dayOfWeek; i < 7; i++) {
        var emptyDay = document.createElement("div");
        emptyDay.classList.add("day");
        emptyDay.classList.add("empty-day"); 
        daysElement.appendChild(emptyDay);
      }
      calendarPopup.style.display = "block";
    }
    displayCalendar(year, month);
  }
</script>
</head>
<body>
  <div class="order_box_date_text">방문일자/인원 선택</div>
  <div class="order_box_date_select" onclick="showCalendar()">
    <img src="images/ticket_images/calendar.png" style="width:40px; height:40px;">
  </div>
  <div id="calendarPopup" class="calendar-popup"></div>
  <div class="order_box_date_date">
    <div id="selectedDate" class="selected-date"></div>
  </div>
</body>
</html>
