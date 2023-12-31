import { Component, AfterViewInit} from '@angular/core';
import * as $ from 'jquery';


@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements AfterViewInit{

  ngAfterViewInit() {
    (function ($) {
      "use strict";

      // Add active state to sidbar nav links
      var path = location.pathname;

      $('#layoutSidenav_nav .sb-sidenav a.nav-link').each((index: any, element: any) => {
        if ($(element).attr('href') === path) {
          $(element).addClass("active");
        }
      });

      $("#sidebarToggle").on("click", function (event: { preventDefault: () => void; }) {
        $("body").toggleClass("sb-sidenav-toggled");
      });
    })(jQuery);
  }
}
