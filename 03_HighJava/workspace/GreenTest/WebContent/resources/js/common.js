// header [pzlsjWn6SL]
(function() {
    $(function() {
      $(".header").each(function() {
        const $block = $(this);
        const $dim = $block.find(".header-dim");
        // Header Scroll
        $(window).on("load scroll", function() {
          const $thisTop = $(this).scrollTop();
          if ($thisTop > 300) {
            $block.addClass(.thwhole - pzlsjWn6SL - top - active ");
            }
            else {
              $block.removeClass(.thwhole - pzlsjWn6SL - top - active ");
              }
            });
          // Gnb DecoLine
          $block.find(".header-gnbitem").each(function() {
            const $this = $(this);
            $this.on("mouseover", function() {
              $this.find(".header-gnblink").addClass("on");
            });
            $this.on("mouseout", function() {
              $this.find(".header-gnblink").removeClass("on");
            });
          });
          // Header Mobile 1Depth Click
          if (window.innerWidth <= 992) {
            $(".fullmenu-gnbitem").each(function() {
              const $sublist = $(this).find(".fullmenu-sublist");
              if ($sublist.length) {
                $(this).find(".fullmenu-gnblink").attr("href", "javascript:void(0);");
              }
            });
          }
        });
      });
    })();
    // hooms-N54 [iZlsjlzD5s]
    (function() {
      $(function() {
        $(".hooms-N54").each(function() {
          const $block = $(this);
          const $dim = $block.find(".header-dim");
          // Header Scroll
          $(window).on("load scroll", function() {
            const $thisTop = $(this).scrollTop();
            if ($thisTop > 0) {
              $block.addClass("header-top-active");
            } else {
              $block.removeClass("header-top-active");
            }
          });
          // Gnb DecoLine
          $block.find(".header-gnbitem").each(function() {
            const $this = $(this);
            $this.on("mouseover", function() {
              $this.find(".header-gnblink").addClass("on");
            });
            $this.on("mouseout", function() {
              $this.find(".header-gnblink").removeClass("on");
            });
          });
          // Header SearchForm
          $block.find(".btn-search").on("click", function() {
            $block.addClass("header-search-active");
            $dim.fadeIn();
          });
          $block.find(".btn-close, .header-dim").on("click", function() {
            $block.removeClass("header-search-active");
            $dim.fadeOut();
          });
          // Full Gnb
          $block.find(".btn-menu").on("click", function() {
            $block.find(".header-fullmenu-dark").addClass("fullmenu-active");
            $block.find(".header-fullmenu-dark .fullmenu-gnbitem .fullmenu-img").show();
          });
          $block.find(".fullmenu-close").on("click", function() {
            $block.find(".header-fullmenu-dark").removeClass("fullmenu-active");
          });
          // Full Gnb Hover
          $block.find(".fullmenu-gnbitem").each(function() {
            const $this = $(this);
            const thisIndex = $this.index();
            $this.find(".fullmenu-gnblink").on("mouseover", function() {
              $block.find(".fullmenu-gnbitem").removeClass("fullmenu-item-active");
              $this.addClass("fullmenu-item-active");
              // Full Gnb Background Img
              const $headerFullmenu = $block.find(".header-fullmenu-dark");
              const classesToRemove = $headerFullmenu.attr("class").split(" ").filter(function(fuillmenu) {
                return fuillmenu.startsWith("header-fullmenu-bg");
              });
              $headerFullmenu.removeClass(classesToRemove.join(" "));
              $headerFullmenu.addClass("header-fullmenu-bg" + thisIndex);
            });
          });
          // Header Mobile 1Depth Click
          if (window.innerWidth <= 992) {
            $(".fullmenu-gnbitem").each(function() {
              const $sublist = $(this).find(".fullmenu-sublist");
              if ($sublist.length) {
                $(this).find(".fullmenu-gnblink").attr("href", "javascript:void(0);");
              }
            });
          }
        });
      });
    })();
    // hooms-N55 [CRLsl1KZQG]
    (function() {
      $(function() {
        $(".hooms-N55").each(function() {
          const $block = $(this);
          const $dim = $block.find(".header-dim");
          // Header Scroll
          $(window).on("load scroll", function() {
            const $thisTop = $(this).scrollTop();
            if ($thisTop > 300) {
              $block.addClass("header-top-active");
            } else {
              $block.removeClass("header-top-active");
            }
          });
          // Gnb DecoLine
          $block.find(".header-gnbitem").each(function() {
            const $this = $(this);
            $this.on("mouseover", function() {
              $this.find(".header-gnblink").addClass("on");
            });
            $this.on("mouseout", function() {
              $this.find(".header-gnblink").removeClass("on");
            });
          });
          // Header SearchForm
          $block.find(".btn-search").on("click", function() {
            $block.addClass("header-search-active");
            $dim.fadeIn();
          });
          $block.find(".btn-close, .header-dim").on("click", function() {
            $block.removeClass("header-search-active");
            $dim.fadeOut();
          });
          // Full Gnb
          $block.find(".btn-menu").on("click", function() {
            $block.find(".header-fullmenu").addClass("fullmenu-active");
            $block.find(".header-fullmenu .fullmenu-gnbitem .fullmenu-img").show();
          });
          $block.find(".fullmenu-close").on("click", function() {
            $block.find(".header-fullmenu").removeClass("fullmenu-active");
          });
          // Full Gnb Hover
          $block.find(".fullmenu-gnbitem").each(function() {
            const $this = $(this);
            const thisIndex = $this.index();
            $this.find(".fullmenu-gnblink").on("mouseover", function() {
              $block.find(".fullmenu-gnbitem").removeClass("fullmenu-item-active");
              $this.addClass("fullmenu-item-active");
              // Full Gnb Background Img
              const $headerFullmenu = $block.find(".header-fullmenu");
              const classesToRemove = $headerFullmenu.attr("class").split(" ").filter(function(fuillmenu) {
                return fuillmenu.startsWith("header-fullmenu-bg");
              });
              $headerFullmenu.removeClass(classesToRemove.join(" "));
              $headerFullmenu.addClass("header-fullmenu-bg" + thisIndex);
            });
          });
          // Header Mobile 1Depth Click
          if (window.innerWidth <= 992) {
            $(".fullmenu-gnbitem").each(function() {
              const $sublist = $(this).find(".fullmenu-sublist");
              if ($sublist.length) {
                $(this).find(".fullmenu-gnblink").attr("href", "javascript:void(0);");
              }
            });
          }
        });
      });
    })();