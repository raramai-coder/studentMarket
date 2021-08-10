from django.contrib import admin
from django.urls import path, include
from django.conf import settings
from django.conf.urls.static import static
from rest_framework import routers
from api import views

router = routers.DefaultRouter()
router.register(r'product', views.ProductViewSet)
router.register(r'order', views.OrderViewSet)
router.register(r'location', views.LocationViewSet)
router.register(r'category', views.CategoryViewSet)
router.register(r'user', views.UserViewSet)

urlpatterns = [
    path('', include(router.urls)),
]

urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)  # static are all files you use for styling
