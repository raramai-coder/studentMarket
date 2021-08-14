from django.shortcuts import render
from rest_framework import viewsets

from api.serializer import ProductSerializer, OrderSerializer, UserSerializer, LocationSerializer, CategorySerializer, \
    SavedSerializer, StoreSerializer, TierSerializer, ReviewSerializer, CartSerializer, OptionsSerializer
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin, Cart, \
    Options


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
    filterset_fields = ['userID', 'categoryID', 'prodLive']


class LocationViewSet(viewsets.ModelViewSet):
    queryset = Location.objects.all()
    serializer_class = LocationSerializer


# class ProductInCategoryViewSet(viewsets.ModelViewSet):
#    queryset = Product.objects.all()
#    serializer_class = ProductSerializer
#    filterset_fields = ['userID', 'categoryID', 'prodLive']


class CategoryViewSet(viewsets.ModelViewSet):
    queryset = Category.objects.all()
    serializer_class = CategorySerializer


class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer


class OrderViewSet(viewsets.ModelViewSet):
    queryset = Order.objects.all()
    serializer_class = OrderSerializer
    filterset_fields = ['userID']

    @action(methods=['post'],detail=True)
    def perform_create(self, serializer):
        serializer.save(owner=self.request.POST)


class SavedViewSet(viewsets.ModelViewSet):
    queryset = Saved.objects.all()
    serializer_class = SavedSerializer
    filterset_fields = ['userID']


class StoreViewSet(viewsets.ModelViewSet):
    queryset = Store.objects.all()
    serializer_class = StoreSerializer
    filterset_fields = ['userID', 'storeName']


class TierViewSet(viewsets.ModelViewSet):
    queryset = Tier.objects.all()
    serializer_class = TierSerializer


class ReviewViewSet(viewsets.ModelViewSet):
    queryset = Review.objects.all()
    serializer_class = ReviewSerializer


class CartViewSet(viewsets.ModelViewSet):
    queryset = Cart.objects.all()
    serializer_class = CartSerializer
    filterset_fields = ['userID', 'orderID']


class OptionsViewSet(viewsets.ModelViewSet):
    queryset = Options.objects.all()
    serializer_class = OptionsSerializer
