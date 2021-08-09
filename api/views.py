from django.shortcuts import render
from rest_framework import viewsets

from api.serializer import ProductSerializer, OrderSerializer, UserSerializer, LocationSerializer, CategorySerializer
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin


# create viewset using serializer
# from api.serializer import FacilitatorSerializer
# from api.models import Facilitator
# Create your views here.
# class facilitatorViewset(viewsets.ModelViewSet):
#    queryset = Facilitator.objects.all().order_by('firstname') #specify how u want data to be returned. ordering etc
#    serializer_class = FacilitatorSerializer

class ProductViewSet(viewsets.ModelViewSet):
    queryset = Product.objects.all().order_by('prodRating')
    serializer_class = ProductSerializer


class LocationViewSet(viewsets.ModelViewSet):
    queryset = Location.objects.all()
    serializer_class = LocationSerializer


class CategoryViewSet(viewsets.ModelViewSet):
    queryset = Category.objects.all()
    serializer_class = CategorySerializer


class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer


class OrderViewSet(viewsets.ModelViewSet):
    queryset = Order.objects.all().order_by('quantity')
    serializer_class = OrderSerializer
