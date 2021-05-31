from rest_framework import status
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response
from rest_framework.views import APIView

from .serializer import *


class AddFavorite(APIView):
    permission_classes = [IsAuthenticated]

    def post(self, request, pk):
        user = request.user
        check = Favorite.objects.filter(product_id=pk, is_favorite=True, user_id=user.id).exists()
        if not check:
            queryset = Favorite.objects.create(product_id=pk, is_favorite=True, user_id=user.id)
            self.check_object_permissions(request, queryset)
            data = FavoriteSerializer(instance=queryset, data=request.data, partial=True)
            if data.is_valid():
                data.save()
                return Response(data.data, status=status.HTTP_201_CREATED)

        return Response({"available": "product is favorite"})


class ListFavorite(APIView):
    permission_classes = [IsAuthenticated]

    def post(self, request):
        user = request.user
        check = Favorite.objects.filter(is_favorite=True, user_id=user.id)
        self.check_object_permissions(request, check)
        data = FavoriteSerializer(check, many=True)
        return Response(data.data, status=status.HTTP_201_CREATED)
